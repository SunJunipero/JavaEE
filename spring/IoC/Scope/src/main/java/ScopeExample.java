import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ScopeExample {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Date singletonBean = context.getBean("non-changing-date", Date.class);
        System.out.println(singletonBean + " hashCode -" + singletonBean.hashCode());
        Thread.sleep(1000);

        singletonBean = context.getBean("non-changing-date", Date.class);
        System.out.println(singletonBean + " hashCode - " + singletonBean.hashCode());
        Thread.sleep(1000);

        singletonBean = context.getBean("non-changing-date", Date.class);
        System.out.println(singletonBean + " hashCode - " + singletonBean.hashCode());
        Thread.sleep(1000);

        Date changeBean = context.getBean("changing-date", Date.class);
        System.out.println(changeBean + " hashCode-" + changeBean.hashCode());
        Thread.sleep(1000);

        changeBean = context.getBean("changing-date", Date.class);
        System.out.println(changeBean + " hashCode-" + changeBean.hashCode());
        Thread.sleep(1000);

        changeBean = context.getBean("changing-date", Date.class);
        System.out.println(changeBean + " hashCode-" + changeBean.hashCode());
        Thread.sleep(1000);
    }
}
