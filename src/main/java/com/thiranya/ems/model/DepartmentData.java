package com.thiranya.ems.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Column(nullable = false, unique = true)
    private int department_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private DepartmentName department_name;

    @OneToMany(mappedBy = "department")
    private List<EmployeeDepartmentData> employees;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public DepartmentName getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(DepartmentName department_name) {
        this.department_name = department_name;
    }

    public List<EmployeeDepartmentData> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDepartmentData> employees) {
        this.employees = employees;
    }
}
