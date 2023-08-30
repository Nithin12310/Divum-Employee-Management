package com.example.DivumEmployeeManagement.Service;

import com.example.DivumEmployeeManagement.Model.Employee;
import com.example.DivumEmployeeManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
//post
    @Override
    public void insert(Employee employee) {
      employeeRepository.save(employee);
    }
//get
    @Override
    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();
    }

    //put

    @Override
    public Employee updateemp(String emailid, Employee employee) {
        Employee updateemp= employeeRepository.findById(emailid).orElseThrow(()-> new RuntimeException("No Records Found"));
        updateemp.setFname(employee.getFname());
        updateemp.setLname(employee.getLname());
        updateemp.setMbno(employee.getMbno());
        updateemp.setDob(employee.getDob());
        updateemp.setAddress(employee.getAddress());

        return employeeRepository.save(updateemp);
    }

    @Override
    public String deleteemp(String emailid) {
        employeeRepository.deleteById(emailid);
        return "one Row Deleted";
    }
}
