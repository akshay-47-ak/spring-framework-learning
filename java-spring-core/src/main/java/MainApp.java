import myPack.userService;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String args[]){

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        userService us = (userService) context.getBean("myBean");

          us.sayHello();
    }
}


