import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestoyExample {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Thread.sleep(2000);


        context.destroy();
    }
}
