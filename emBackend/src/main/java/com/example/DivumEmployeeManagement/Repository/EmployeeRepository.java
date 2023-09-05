package com.example.DivumEmployeeManagement.Repository;

import com.example.DivumEmployeeManagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,String> {


}
