package looseCoupling;

public class BeanLifeCycle {

    private EngineService engineService;


    public BeanLifeCycle(EngineService engineService) {
        System.out.println("Contructor Called : Dependency Injected ");
        this.engineService = engineService;
    }

    public void init(){
        System.out.println("init called: Bean Initialized");
    }

    public void performTask(){
        System.out.println("Ready For use!");
    }

    public void cleanup(){
        System.out.println("cleanup() being called");
    }
}
