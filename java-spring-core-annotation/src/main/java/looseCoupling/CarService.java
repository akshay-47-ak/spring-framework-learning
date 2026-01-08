package looseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carService")
public class CarService {
    /*
       1)If Remove the Defult Constructor Spring throws the Error if we don't use Autowire Annotation
       2)If We Remove the Defult Constructor and Autowire Annotation then spring Automatically Manages
         Constructor arg itself and code run smoothly
     */

    EngineService engineService;
    public CarService() {
    }

    @Autowired
    public CarService(EngineService engineService) {
        this.engineService = engineService;
    }

    public EngineService getEngineService() {
        return engineService;
    }

    public void setEngineService(EngineService engineService) {
        this.engineService = engineService;
    }

    public void startEngine(){
        engineService.startEngine();
        System.out.println("Car Started");
    }
}
