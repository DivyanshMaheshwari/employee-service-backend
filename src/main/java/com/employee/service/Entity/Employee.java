package com.employee.service.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "salary")
    private Long salary;

    @Column(name = "name")
    private String name;
    @Column(name = "department_id")
    private Long departmentId;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
