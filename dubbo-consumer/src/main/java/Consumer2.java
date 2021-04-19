import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.djc.cross.WorldService;

public class Consumer2 {
    public static void main(String[] args) {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");
        application.setOwner("sihai");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("N/A");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<WorldService> reference = new ReferenceConfig<WorldService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(WorldService.class);

        // 和本地bean一样使用xxxService
        WorldService service = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        service.testDubbo();
    }
}
