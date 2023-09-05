package com.example.DivumEmployeeManagement.Controller;

import com.example.DivumEmployeeManagement.Model.Employee;
import com.example.DivumEmployeeManagement.Repository.EmployeeRepository;
import com.example.DivumEmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("divumemp")
@CrossOrigin
public class EmployeeControler {

    @Autowired
    EmployeeService employeeService;

//checking whether the mail is exist or not


//post
    @PostMapping("/insert")
    public String insert(@RequestBody Employee employee){
        employeeService.insert(employee);
        return"One record is inserted";
    }
    //get
    @GetMapping("/fetch")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    //geting for mail validation
    @GetMapping("/checkemail/{email}")
    public String  checkuser(@PathVariable String email){
        return employeeService.getbyid(email);

    }
//put
    @PutMapping("/update/{emailid}")
    public String updateemp(@PathVariable String emailid, @RequestBody Employee employee){
        employeeService.updateemp(emailid, employee);
        return "Employee Updated!";
    }

//delete
    @DeleteMapping("/delete/{emailid}")
    public String deleteemp(@PathVariable String emailid){
        return employeeService.deleteemp(emailid);
    }

}
