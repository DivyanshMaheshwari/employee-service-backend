package com.employee.service.DTO;

public class Department {
    private String name;
    private String location;

    // Constructors
    public Department() {}

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
