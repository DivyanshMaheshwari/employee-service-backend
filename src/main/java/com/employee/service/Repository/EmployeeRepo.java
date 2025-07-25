package com.employee.service.Repository;

import com.employee.service.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByName(String name);
}
