package myPack;

import org.springframework.stereotype.Component;

@Component("myBean")
public class userService {

    public void sayHello(){
        System.out.println("Hello EveryOne");
    }
}
