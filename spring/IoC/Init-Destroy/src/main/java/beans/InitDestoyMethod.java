package beans;

public class InitDestoyMethod {
    public void initMethod(){
        System.out.println("hello from " + InitDestoyMethod.class.getCanonicalName() + "from init method" );
    }

    public void destroyMethod(){
        System.out.println("hello from " + InitDestoyMethod.class.getCanonicalName() + "from destroy method" );
    }
}
