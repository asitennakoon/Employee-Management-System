package com.thiranya.app.service;

import com.thiranya.app.model.Department;
import com.thiranya.app.model.Department.DepartmentName;
import com.thiranya.app.model.Employee;
import com.thiranya.app.model.EmployeePrimaryKey;
import com.thiranya.app.repository.DepartmentRepository;
import com.thiranya.app.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  EmployeeRepository employeeRepo;
  DepartmentRepository departmentRepo;

  public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
    this.employeeRepo = employeeRepo;
    this.departmentRepo = departmentRepo;
  }

  public Employee findById(Integer employeeId, Integer departmentId) {
    return employeeRepo.findByPrimaryKey(employeeId, departmentId);
  }

  public Iterable<Employee> getAllEmployees() {
    return employeeRepo.findAll();
  }

  public List<Employee> nicStartWith90() {
    return employeeRepo.nicStartWith90();
  }

  public List<Employee> workingForFiveYears() {
    return employeeRepo.workingForFiveYears();
  }

  public Employee addEmployee(Employee employee) {
    Department department = new Department(employee.getDepartmentId(),
        DepartmentName.values()[employee.getDepartmentId() - 1]);

    employee.setDepartment(department);
    return employeeRepo.save(employee);
  }

  public Employee viewEmployeeByName(String employeeName) {
    return employeeRepo.viewEmployeeByName(employeeName);
  }

  public List<Employee> getEmployeesByDepartmentName(Department.DepartmentName departmentName) {
    return employeeRepo.getEmployeesByDepartmentName(departmentName.toString());
  }

  public Employee editEmployee(Employee employee) {
    Employee outdatedEmployee = findById(employee.getEmployeeId(), employee.getDepartmentId());

    employeeRepo.delete(outdatedEmployee);
    return addEmployee(employee);
  }

  public void deleteEmployee(Integer employeeId, Integer departmentId) {
    employeeRepo.deleteById(new EmployeePrimaryKey(employeeId, departmentId));
  }

}
