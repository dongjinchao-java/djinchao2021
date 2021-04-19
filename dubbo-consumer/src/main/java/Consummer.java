import org.djc.cross.WorldService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consummer {
    public static void main(String[] args){
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext-consumer.xml");
            context.start();
            WorldService service = (WorldService) context.getBean("worldService");
            String str = service.testDubbo();
            System.out.println(str);
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
