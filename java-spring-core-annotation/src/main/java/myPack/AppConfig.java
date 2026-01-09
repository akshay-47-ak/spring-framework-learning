package myPack;

import looseCoupling.BeanLifeCycle;
import looseCoupling.EngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "looseCoupling")
public class AppConfig {

    @Bean
    public BeanLifeCycle beanLifeCycle(EngineService engineService){
        return  new BeanLifeCycle(engineService);
    }
}
