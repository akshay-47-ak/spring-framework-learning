import looseCoupling.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String args[]){

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

      CarService cs = (CarService) context.getBean("carService");

      cs.StartCar();

    }
}


