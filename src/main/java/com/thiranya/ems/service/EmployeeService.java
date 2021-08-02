package com.thiranya.ems.service;

import com.thiranya.ems.model.DepartmentData.DepartmentName;
import com.thiranya.ems.model.EmployeeData;
import com.thiranya.ems.repository.DepartmentRepository;
import com.thiranya.ems.repository.EmployeeRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;

    public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public Iterable<EmployeeData> nicStartWith90(String prefix) {
        return employeeRepo.findByNicIsStartingWith(prefix);
    }

    public Iterable<EmployeeData> workingForFiveYears(int year) {
        LocalDate currentDate = LocalDate.now();

        return employeeRepo.findByStart_dateBefore(currentDate.minusYears(year));
    }

    public EmployeeData addEmployee(EmployeeData employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<EmployeeData> viewEmployeesByName(String employeeName) {
        return employeeRepo.findByFirst_nameOrLast_name(employeeName, employeeName);
    }

    public Iterable<EmployeeData> getEmployeesByDepartmentName(DepartmentName departmentName) {
        return employeeRepo.getEmployeesByDepartmentName(departmentName.toString());
    }

    public EmployeeData editEmployee(EmployeeData employee) {
        employeeRepo.updateEmployee(employee.getFirst_name(), employee.getLast_name(),
                employee.getMobile_number(), employee.getDesignation(), employee.getEmployee_id());
        return employeeRepo.findById(employee.getEmployee_id()).orElse(null);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    public void addEmpDepEntry(Integer employeeId, Integer departmentId) {
        if (employeeRepo.findEntry(employeeId, departmentId) == 0) {
            employeeRepo.insertEmpDepEntry(employeeId, departmentId);
        }
    }

}
