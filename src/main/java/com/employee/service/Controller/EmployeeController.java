package com.employee.service.Controller;

import com.employee.service.DTO.EmployeeWithDepartmentDTO;
import com.employee.service.Entity.Employee;
import com.employee.service.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public Employee createUser(@RequestBody Employee employee) {
        return employeeService.createUser(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllUsers() {
        return employeeService.getAllUser();
    }

    @GetMapping("/{id}")
    public Employee getUserById(@PathVariable Long id) {
        return employeeService.getUserById(id);
    }

    @GetMapping("/MaxSalary")
    public Long maxSalary() {
        return employeeService.maxSalary();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        employeeService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public Employee updateUser(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateUser(id, employee);
    }
    @GetMapping("/name/{name}")
    public List<Employee> searchByName(@PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }
    @GetMapping("/with-department/{id}")
    public EmployeeWithDepartmentDTO getEmployeeWithDepartment(@PathVariable Long id) {
        return employeeService.getEmployeeWithDepartment(id);
    }

}
