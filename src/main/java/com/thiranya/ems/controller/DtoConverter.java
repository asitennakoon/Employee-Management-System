package com.thiranya.ems.controller;

import com.thiranya.ems.model.Employee;
import com.thiranya.ems.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    public Employee convertToDto(EmployeeData employeeData) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeData.getEmployee_id());
        employee.setFirstName(employeeData.getFirst_name());
        employee.setLastName(employeeData.getLast_name());
        employee.setNic(employeeData.getNic());
        employee.setDesignation(employeeData.getDesignation());
        employee.setMobileNumber(employeeData.getMobile_number());
        employee.setStartDate(String.valueOf(employeeData.getStart_date()));
        return employee;
    }

    public EmployeeData convertToEntity(Employee employee) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setFirst_name(employee.getFirstName());
        employeeData.setLast_name(employee.getLastName());
        employeeData.setNic(employee.getNic());
        employeeData.setDesignation(employee.getDesignation());
        employeeData.setMobile_number(employee.getMobileNumber());
        employeeData.setStart_date(employee.getStartDate());
        return employeeData;
    }
}
