package com.thiranya.ems.service;

import com.thiranya.ems.model.DepartmentData.DepartmentName;
import com.thiranya.ems.model.EmployeeData;
import com.thiranya.ems.repository.DepartmentRepository;
import com.thiranya.ems.repository.EmployeeDepartmentRepository;
import com.thiranya.ems.repository.EmployeeRepository;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;
    private final EmployeeDepartmentRepository employeeDepartmentRepository;

    public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo,
            EmployeeDepartmentRepository employeeDepartmentRepository) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
        this.employeeDepartmentRepository = employeeDepartmentRepository;
    }

    public Iterable<Optional<EmployeeData>> nicStartWith90() {
        return employeeRepo.findByNicIsStartingWith("90");
    }

    public Iterable<Optional<EmployeeData>> workingForFiveYears() {
        LocalDate currentDate = LocalDate.now();

        return employeeRepo.findByStart_dateBefore(currentDate.minusYears(5));
    }

    public EmployeeData addEmployee(EmployeeData employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Optional<EmployeeData>> viewEmployeesByName(String employeeName) {
        return employeeRepo.findByFirst_nameOrLast_name(employeeName, employeeName);
    }

    public Iterable<Optional<EmployeeData>> getEmployeesByDepartmentName(
            DepartmentName departmentName) {
        List<Optional<EmployeeData>> response = new java.util.ArrayList<>(Collections.emptyList());

        employeeDepartmentRepository.getEmployeeIdsOfDepartment(departmentName)
                .forEach(integer -> response.add(employeeRepo.findById(integer)));
        return response;
    }

    public EmployeeData editEmployee(EmployeeData employee) {
        employeeRepo.deleteById(employee.getEmployee_id());
        return addEmployee(employee);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeRepo.deleteById(employeeId);
    }

}
