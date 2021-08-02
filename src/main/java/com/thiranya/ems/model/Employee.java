package com.thiranya.ems.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String nic;
    private String designation;
    private String mobileNumber;
    private LocalDate startDate;
    private int departmentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nic='" + nic + '\'' +
                ", designation='" + designation + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", startDate=" + startDate +
                ", departmentId=" + departmentId +
                '}';
    }
}
