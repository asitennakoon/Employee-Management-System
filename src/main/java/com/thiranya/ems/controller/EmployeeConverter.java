package com.thiranya.ems.controller;

import com.thiranya.ems.model.Employee;
import com.thiranya.ems.repository.model.EmployeeData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public Employee convertToDto(EmployeeData employeeData) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeData.getEmployeeId());
        employee.setFirstName(employeeData.getFirstName());
        employee.setLastName(employeeData.getLastName());
        employee.setNic(employeeData.getNic());
        employee.setDesignation(employeeData.getDesignation());
        employee.setMobileNumber(employeeData.getMobileNumber());
        employee.setStartDate(String.valueOf(employeeData.getStartDate()));
        return employee;
    }

    public EmployeeData convertToEntity(Employee employee) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployeeId(employee.getEmployeeId());
        employeeData.setFirstName(employee.getFirstName());
        employeeData.setLastName(employee.getLastName());
        employeeData.setNic(employee.getNic());
        employeeData.setDesignation(employee.getDesignation());
        employeeData.setMobileNumber(employee.getMobileNumber());
        employeeData.setStartDate(employee.getStartDate());
        return employeeData;
    }

    public List<Employee> convertToDtoList(List<EmployeeData> employeeDataList) {
        List<Employee> employeeList = new ArrayList<>();

        for (EmployeeData employeeData : employeeDataList) {
            employeeList.add(convertToDto(employeeData));
        }
        return employeeList;
    }
}
