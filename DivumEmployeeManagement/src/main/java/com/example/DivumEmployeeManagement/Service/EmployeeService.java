package com.example.DivumEmployeeManagement.Service;

import com.example.DivumEmployeeManagement.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EmployeeService {
    //post functionaliy
    public void insert(Employee employee);

    //get functionality

    public List<Employee> getAllEmployee();

    //put functionality
    public Employee updateemp(String id,Employee employee);

    //delete Functionality
    public String deleteemp(String emailid);
}
