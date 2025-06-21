package com.employee.service.Service;

import com.employee.service.DTO.Department;
import com.employee.service.DTO.EmployeeWithDepartmentDTO;
import com.employee.service.Entity.Employee;
import com.employee.service.FeignClient.DepartmentClient;
import com.employee.service.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentClient departmentClient;

    public List<Employee> getAllUser() {
        return employeeRepo.findAll();
    }

    public Employee createUser(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee getUserById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id : " + id));
    }

    public Long maxSalary() {
        return employeeRepo.
                findAll().
                stream().
                max(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary)
                .orElse(null);
    }

    public void deleteUser(Long id) {
        employeeRepo.deleteById(id);
    }

    public Employee updateUser(Long id, Employee employee) {
        Employee existing = getUserById(id);
        existing.setName(employee.getName());
        existing.setSalary(employee.getSalary());

        return employeeRepo.save(existing);
    }

    public List<Employee> findEmployeeByName(String name) {
        return employeeRepo.findByName(name);
    }

    public EmployeeWithDepartmentDTO getEmployeeWithDepartment(Long employeeId) {
        Employee employee = getUserById(employeeId);
        Department department = departmentClient.getDepartmentById(employee.getDepartmentId());
        return new EmployeeWithDepartmentDTO(employee.getId(),
                employee.getName(),
                employee.getDepartmentId(),
                department.getName(),
                department.getLocation()
        );
    }
}
