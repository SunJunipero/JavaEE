package bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class LazyInitExample {

    private static Logger logger = LoggerFactory.getLogger(LazyInitExample.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        logger.debug("\n\n\n");
        Date bean = context.getBean("not-lazy-Date", Date.class);

        //System.out.println(bean);
        logger.debug("not lazy: {}", bean);

        Date bean1 = context.getBean("lazy-date", Date.class);
        //System.out.println(bean1);
        logger.debug("lazy: {}", bean1);

    }
}
