package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InterfaceInitDestoyBean implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {
        System.out.println("By-by InterfaceInitDestoyBean");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Hi-hi from afterPropertiesSet");

    }
}
