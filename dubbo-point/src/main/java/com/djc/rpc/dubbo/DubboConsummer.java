package com.djc.rpc.dubbo;

import com.alibaba.dubbo.config.*;
import org.djc.cross.WorldService;

public class DubboConsummer {

    // ע�⣺ServiceConfigΪ�ض����ڲ���װ����ע�����ĵ����ӣ��Լ���������˿�
    private ReferenceConfig<WorldService> reference;

    private static DubboConsummer instance = new DubboConsummer();

    public static DubboConsummer getInstance() {
        return instance;
    }

    public void initComsummer() {
        // ��ǰӦ������
        ApplicationConfig application = new ApplicationConfig();
        application.setName("djinchao2021");

        // ����ע����������
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("N/A");
        //registry.setUsername("aaa");
        //registry.setPassword("bbb");

        // ע�⣺ReferenceConfigΪ�ض����ڲ���װ����ע�����ĵ����ӣ��Լ�������ṩ��������

        // ����Զ�̷���
        reference = new ReferenceConfig<WorldService>(); // ��ʵ�����أ���װ����ע�����ĵ������Լ����ṩ�ߵ����ӣ������л��棬�����������ڴ������й©
        reference.setApplication(application);
        reference.setRegistry(registry); // ���ע�����Ŀ�����setRegistries()
        reference.setInterface(WorldService.class);
        reference.setVersion("1.0.0");
        reference.setTimeout(1);

// �ͱ���beanһ��ʹ��xxxService
        WorldService xxxService = reference.get(); // ע�⣺�˴�������ڲ���װ������ͨѶϸ�ڣ�������أ��뻺�渴��
    }

    public WorldService getWorldService(String url) {
        reference.setUrl(url);
        return reference.get(); // ע�⣺�˴�������ڲ���װ������ͨѶϸ�ڣ�������أ��뻺�渴��
    }
}
