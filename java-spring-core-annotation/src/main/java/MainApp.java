import looseCoupling.CarService;
import myPack.AppConfig;
import myPack.userService;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String args[]){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      userService us = (userService) context.getBean("myBean");

       us.sayHello();

    }
}


