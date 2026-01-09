package looseCoupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/*
Primary Annotation is also used for Set primary been when multiple beans are there in one Interface
 */
@Component
@Primary
public class PetrolEngine implements EngineService{

    public void startEngine(){
        System.out.println("Petrol Engine Started");
    }
}
