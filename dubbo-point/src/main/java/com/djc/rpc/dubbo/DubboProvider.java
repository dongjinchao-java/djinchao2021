package com.djc.rpc.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.djc.rpc.serviceImpl.WorldServiceImpl;
import org.djc.cross.WorldService;

public class DubboProvider {

    // ע�⣺ServiceConfigΪ�ض����ڲ���װ����ע�����ĵ����ӣ��Լ���������˿�
    private ServiceConfig<WorldService> service;

    private static DubboProvider instance = new DubboProvider();

    public static DubboProvider getInstance() {
        return instance;
    }

    public void initProvider() {
        // ��ǰӦ������
        ApplicationConfig application = new ApplicationConfig();
        application.setName("djnchao2021");
        // ����ע����������
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("N/A");
        registry.setUsername("aaa");
        registry.setPassword("bbb");

        // �����ṩ��Э������
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        protocol.setThreads(200);

        // �����ṩ�߱�¶��������
        service = new ServiceConfig<WorldService>();
        service.setApplication(application);
        service.setRegistry(registry); // ���ע�����Ŀ�����setRegistries()
        service.setProtocol(protocol); // ���Э�������setProtocols()
        service.setInterface(WorldService.class);
        service.setRef((WorldService) new WorldServiceImpl());
        service.setVersion("1.0.0");
        // ��¶��ע�����
        service.export();
    }
}
