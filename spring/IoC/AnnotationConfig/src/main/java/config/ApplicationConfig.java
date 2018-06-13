package config;

import beans.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfig {

    @Bean
    public SimpleBean getSimpleBean(){
        return new SimpleBean();
    }
}
