package myPack;

import looseCoupling.BeanLifeCycle;
import looseCoupling.EngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "looseCoupling")
public class AppConfig {
    /* What is Diffrance Between Bean And Component?

    Both Work same but we use Bean Annotation when we can't make changes in class directly
    To Avoid changes Direct in Class we use Bean Annotation On the Class Object As Give Below
     */

    @Bean(initMethod = "init ",destroyMethod = "cleanup")
    public BeanLifeCycle beanLifeCycle(EngineService engineService){
        return  new BeanLifeCycle(engineService);
    }
}
