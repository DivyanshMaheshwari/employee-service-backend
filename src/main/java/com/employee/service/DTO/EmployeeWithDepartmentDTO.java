package com.employee.service.DTO;

public class EmployeeWithDepartmentDTO {
    private Long employeeId;
    private String employeeName;
    private Long departmentId;
    private String departmentName;
    private String departmentLocation;

    // Getters, Setters, Constructor

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public EmployeeWithDepartmentDTO(Long employeeId, String employeeName, Long departmentId, String departmentName, String departmentLocation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }
}
