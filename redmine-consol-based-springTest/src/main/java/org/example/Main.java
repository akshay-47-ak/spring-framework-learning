package org.example;

import org.example.Controllar.EmpController;
import org.example.Service.EmployeeService;
import org.example.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]){

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
   EmpController emp = context.getBean(EmpController.class);

       emp.addEmp();


    }
}
