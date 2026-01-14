package org.example.Controllar;

import org.example.Service.EmployeeService;
import org.example.ViewModel.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmpController {

     @Autowired
    EmployeeService employeeService;

    public void addEmp(Integer empId, String empName, String empDept){
       Employee emp = new Employee(empId,empName,empDept);
        employeeService.save(emp);
    }

}
