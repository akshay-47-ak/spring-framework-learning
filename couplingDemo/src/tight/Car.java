package tight;

public class Car {
    Engine engine = new Engine();

/*
Problem -Tight Coupling
Car depends directly on Engine
Cannot replace Engine easily
Testing becomes hard
Any change in Engine may break Car
*/

    void start(){
        engine.start();
        System.out.println("car moving");
    }
}
