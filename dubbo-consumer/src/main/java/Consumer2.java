import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.djc.cross.WorldService;

public class Consumer2 {
    public static void main(String[] args) {
        // ��ǰӦ������
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");
        application.setOwner("sihai");

        // ����ע����������
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("N/A");

        // ע�⣺ReferenceConfigΪ�ض����ڲ���װ����ע�����ĵ����ӣ��Լ�������ṩ��������

        // ����Զ�̷���
        ReferenceConfig<WorldService> reference = new ReferenceConfig<WorldService>(); // ��ʵ�����أ���װ����ע�����ĵ������Լ����ṩ�ߵ����ӣ������л��棬�����������ڴ������й©
        reference.setApplication(application);
        reference.setRegistry(registry); // ���ע�����Ŀ�����setRegistries()
        reference.setInterface(WorldService.class);

        // �ͱ���beanһ��ʹ��xxxService
        WorldService service = reference.get(); // ע�⣺�˴�������ڲ���װ������ͨѶϸ�ڣ�������أ��뻺�渴��
        service.testDubbo();
    }
}
