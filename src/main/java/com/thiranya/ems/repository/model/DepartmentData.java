package com.thiranya.ems.repository.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentData {

    public enum DepartmentName {
        ENGINEERING,
        IMPLEMENTATION,
        SUPPORT,
        BS,
        MARKETING,
        HR
    }

    @Id
    @GeneratedValue
    @Column(name = "department_id", nullable = false, unique = true)
    private int departmentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "department_name", nullable = false, unique = true)
    private DepartmentName departmentName;

    @ManyToMany(mappedBy = "departments")
    private List<EmployeeData> employees;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int department_id) {
        this.departmentId = department_id;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName department_name) {
        this.departmentName = department_name;
    }

    public List<EmployeeData> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeData> employees) {
        this.employees = employees;
    }
}
