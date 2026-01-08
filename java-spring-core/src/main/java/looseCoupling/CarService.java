package looseCoupling;

public class CarService {
    EcoEngine ecoEngine;
    public CarService() {
    }
    public void StartCar(){
        ecoEngine.startEngine();
        System.out.println("Car Started");
    }

    public CarService(EcoEngine ecoEngine) {
        this.ecoEngine = ecoEngine;
    }

    public EcoEngine getEcoEngine() {
        return ecoEngine;
    }

    public void setEcoEngine(EcoEngine ecoEngine) {
        this.ecoEngine = ecoEngine;
    }
}
