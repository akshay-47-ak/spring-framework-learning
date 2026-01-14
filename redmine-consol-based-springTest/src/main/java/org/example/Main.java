package org.example;

import org.example.Controllar.EmpController;
import org.example.Service.EmployeeService;
import org.example.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]){

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
   EmpController emp = context.getBean(EmpController.class);

    Scanner sc = new Scanner(System.in);
    boolean running = true;
        while (running) {
            System.out.println("""
                    1)Add Employee
                    2)List Emplpoyee's
                    
                   
                    """);
            System.out.println("CHOOSE: ");
            String choice = sc.nextLine().trim();
            System.out.println("CHOICE :" + choice);


            switch (choice){
                case "0" -> running =false;
                case "1" -> addEmployee(sc , emp);
                case "2" -> listEmployee(emp);

            }
        }


    }

    private static void addEmployee(Scanner sc, EmpController emp) {
        System.out.println("Enter a Employee ID :");
         Integer empId = sc.nextInt();
         sc.nextLine();
        System.out.println("Enter a Employee Name :");
         String empName = sc.nextLine();
        System.out.println("Enter a Employee DepartmentS :");
         String empDept = sc.nextLine();

         emp.addEmp(empId,empName,empDept);

    }
    private static void listEmployee(EmpController emp) {
        emp.listEmp();
    }
}
