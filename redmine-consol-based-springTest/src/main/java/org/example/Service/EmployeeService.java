package org.example.Service;

import org.example.DB.Employee;
import org.example.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    Repo repo;

    public void save(Employee employee){
       repo.save(employee);
    }

}
