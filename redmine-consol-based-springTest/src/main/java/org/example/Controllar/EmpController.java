package org.example.Controllar;

import org.example.Service.EmployeeService;
import org.example.ViewModel.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    public void addEmp(Integer empId, String empName, String empDept){
       Employee emp = new Employee(empId,empName,empDept);
        employeeService.save(emp);
    }

    public void listEmp(){
        Map<Integer,Employee> map = employeeService.listEmp();
       for(Employee emp : map.values()){
           System.out.println(emp);
       }
    }

}
