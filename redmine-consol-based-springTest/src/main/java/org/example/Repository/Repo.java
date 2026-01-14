package org.example.Repository;

import org.example.ViewModel.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Repo {

  private Map<Integer,Employee> employeeDb = new HashMap<>();

  public void save(Employee employee){
      employeeDb.put(employee.getEmpId(),employee);
      System.out.println("Employee Saved With EmpID: " + employee.getEmpId());
  }

  public Map<Integer,Employee> listEmp(){
      return employeeDb;
  }



}
