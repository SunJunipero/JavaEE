import bean.Adult;
import bean.Child;
import bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.krb5.internal.PAEncTSEnc;

public class InheritanceExample {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Adult adult = context.getBean("adult", Adult.class);

        System.out.println(adult);

        Child child = context.getBean("child", Child.class);

        System.out.println(child.getName());

        System.out.println(child.getParent().getSirial());

    }
}
