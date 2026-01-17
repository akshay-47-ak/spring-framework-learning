package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartCLR implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Is Started At Command Line Runner");
    }
}
