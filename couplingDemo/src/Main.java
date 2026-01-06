import loose.Car;
import loose.DigelEngine;
import loose.Engine;
import loose.PetrolEngine;

public  class Main {
    public static  void main(String args[]){
     /*
        Here we use Loose Coupling We don't have to change the class or Method
     */
        Engine engine = new DigelEngine();
        Engine engine1 = new PetrolEngine();

        Car car = new Car(engine);

        car.drive();

    }
}