package looseCoupling;

import org.springframework.stereotype.Component;

@Component("ecoEngine")
public class EcoEngine implements EngineService{
    @Override
    public void startEngine() {
        System.out.println("Eco Engine Start");
    }
}
