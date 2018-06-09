package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationsBean {
    @PostConstruct
    public void postConstructMethod(){
        System.out.println("PostConstruct method");
    }
    @PreDestroy
    public void predestroyMethod(){
        System.out.println("predestroyMethod");
    }
}
