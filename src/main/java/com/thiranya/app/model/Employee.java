package com.thiranya.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@IdClass(EmployeePrimaryKey.class)
public class Employee {

  @Id
  @Column(length = 3, nullable = false, unique = true)
  private int employeeId;

  @Id
  @Column(length = 2, nullable = false)
  private int departmentId;

  @Column(length = 25, nullable = false)
  private String firstName;

  @Column(length = 25, nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String nic;

  @Column(length = 25, nullable = false)
  private String designation;

  @Column(length = 10, nullable = false, unique = true)
  private int mobileNumber;

  @Column(nullable = false)
  private LocalDate startDate;

  @ManyToOne
  @JoinColumn(name = "department_fk", nullable = false)
  @JsonBackReference
  private Department department;

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public int getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(int mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Employee [employeeId=" + employeeId + ", departmentId=" + departmentId + ", firstName="
        + firstName
        + ", lastName=" + lastName + ", nic=" + nic + ", designation=" + designation
        + ", mobileNumber="
        + mobileNumber + ", startDate=" + startDate + ", department=" + department + "]";
  }

}
