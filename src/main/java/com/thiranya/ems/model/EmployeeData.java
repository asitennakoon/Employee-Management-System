package com.thiranya.ems.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeData {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private int employee_id;

    @Column(length = 25, nullable = false)
    private String first_name;

    @Column(length = 25, nullable = false)
    private String last_name;

    @Column(nullable = false, unique = true)
    private String nic;

    @Column(length = 25, nullable = false)
    private String designation;

    @Column(nullable = false, unique = true)
    private String mobile_number;

    @Column(nullable = false)
    private LocalDate start_date;

    @ManyToMany
    @JoinTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<DepartmentData> departments;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public List<DepartmentData> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentData> departments) {
        this.departments = departments;
    }
}
