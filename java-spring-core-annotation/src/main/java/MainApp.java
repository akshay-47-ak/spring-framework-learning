import looseCoupling.BeanLifeCycle;
import looseCoupling.CarService;
import myPack.AppConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {

    public static void main(String args[]){
        System.out.println("Starting Spring Application Context");
      ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    /*   CarService cs  = (CarService) context.getBean(CarService.class);

       cs.startEngine();
*/
        System.out.println("Retriving Life Cycle Been");
        BeanLifeCycle beanLifeCycle = context.getBean(BeanLifeCycle.class);

        beanLifeCycle.performTask();

        System.out.println("Closing Spring Context");

    }
}


