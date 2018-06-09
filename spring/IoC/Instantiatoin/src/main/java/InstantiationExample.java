import bean.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstantiationExample {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Person bean = context.getBean("default-constructor-person", Person.class);
        System.out.println("\t default constructor");
        System.out.println(gson.toJson(bean));
        System.out.println("\n\n");

        bean = context.getBean("arg-constructor-person", Person.class);
        System.out.println("\t arg constructor");
        System.out.println(gson.toJson(bean));
        System.out.println("\n\n");

        bean = context.getBean("default-factory-method", Person.class);
        System.out.println("\t default-factory-method");
        System.out.println(gson.toJson(bean));
        System.out.println("\n\n");

        bean = context.getBean("argument-factory-method", Person.class);
        System.out.println("\t argument factory method");
        System.out.println(gson.toJson(bean));
        System.out.println("\n\n");

    }
}
