package com.thiranya.ems.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class EmployeeDepartmentData {

    @EmbeddedId
    private EmployeeDepartmentKey id;

    @ManyToOne
    @MapsId("employee_id")
    @JoinColumn
    private EmployeeData employee;

    @ManyToOne
    @MapsId("department_id")
    @JoinColumn
    private DepartmentData department;

    private int year;

    public EmployeeDepartmentKey getId() {
        return id;
    }

    public void setId(EmployeeDepartmentKey id) {
        this.id = id;
    }

    public EmployeeData getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeData employee) {
        this.employee = employee;
    }

    public DepartmentData getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentData department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
