import bean.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class BeanExample {

    private static Logger logger = LoggerFactory.getLogger(BeanExample.class);

    public static void main(String[] args) {

        File file = new File("/home/kostya/IdeaProjects/JavaEE/spring/IoC/SimpleBean/src/main/resources/context.xml");
        System.out.println("file exist - " + file.exists());
        String filePath = "/home/kostya/IdeaProjects/JavaEE/spring/IoC/SimpleBean/src/main/resources/context.xml";
        ApplicationContext context = new GenericXmlApplicationContext("classpath:context.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/context.xml");

        logger.debug("\n\n\n");

        Car car = context.getBean("car", Car.class);
        logger.debug("Car model: {}", car.getModel());
        System.out.println(car.getModel());
    }
}
