package com.thiranya.ems.service;

import com.thiranya.ems.repository.EmployeeRepository;
import com.thiranya.ems.repository.model.DepartmentData.DepartmentName;
import com.thiranya.ems.repository.model.EmployeeData;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<EmployeeData> nicStartWith90(String prefix) {
        return employeeRepo.findByNicIsStartingWith(prefix);
    }

    public List<EmployeeData> workingForFiveYears(int year) {
        LocalDate currentDate = LocalDate.now();

        return employeeRepo.findByStartDateBefore(currentDate.minusYears(year));
    }

    public EmployeeData addEmployee(EmployeeData employee) {
        return employeeRepo.save(employee);
    }

    public List<EmployeeData> viewEmployeesByName(String employeeName) {
        return employeeRepo.findByFirstNameOrLastName(employeeName, employeeName);
    }

    public List<EmployeeData> getEmployeesByDepartmentName(DepartmentName departmentName) {
        return employeeRepo.getEmployeesByDepartmentName(departmentName.toString());
    }

    public EmployeeData editEmployee(EmployeeData employee) {
        employeeRepo.updateEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getMobileNumber(), employee.getDesignation(), employee.getEmployeeId());
        return employeeRepo.findById(employee.getEmployeeId()).orElse(null);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    public void addEmpDepEntry(Integer employeeId, Integer departmentId) {
        if (employeeRepo.findEntry(employeeId, departmentId) == 0) {
            employeeRepo.insertEmpDepEntry(employeeId, departmentId);
        }
    }

    public Optional<EmployeeData> findById(Integer employeeId) {
        return employeeRepo.findById(employeeId);
    }

}
