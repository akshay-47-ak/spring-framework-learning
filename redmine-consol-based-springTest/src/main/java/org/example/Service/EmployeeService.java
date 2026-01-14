package org.example.Service;

import org.example.ViewModel.Employee;
import org.example.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    Repo repo;

    public void save(Employee employee){
       repo.save(employee);

    }

    public Map<Integer,Employee> listEmp(){
        return repo.listEmp();
    }

}
