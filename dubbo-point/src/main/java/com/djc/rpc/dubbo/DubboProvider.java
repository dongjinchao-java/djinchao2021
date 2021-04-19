package com.djc.rpc.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.djc.rpc.serviceImpl.WorldServiceImpl;
import org.djc.cross.WorldService;

public class DubboProvider {

    // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
    private ServiceConfig<WorldService> service;

    private static DubboProvider instance = new DubboProvider();

    public static DubboProvider getInstance() {
        return instance;
    }

    public void initProvider() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("djnchao2021");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("N/A");
        registry.setUsername("aaa");
        registry.setPassword("bbb");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        protocol.setThreads(200);

        // 服务提供者暴露服务配置
        service = new ServiceConfig<WorldService>();
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(WorldService.class);
        service.setRef((WorldService) new WorldServiceImpl());
        service.setVersion("1.0.0");
        // 暴露及注册服务
        service.export();
    }
}
