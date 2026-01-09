import looseCoupling.CarService;
import myPack.AppConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {

    public static void main(String args[]){

      ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       CarService cs  = (CarService) context.getBean(CarService.class);

       cs.startEngine();

    }
}


