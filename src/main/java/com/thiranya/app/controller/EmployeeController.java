package com.thiranya.app.controller;

import com.thiranya.app.model.Department;
import com.thiranya.app.model.Employee;
import com.thiranya.app.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("")
  public List<Employee> searchEmployee(@RequestParam("condition") String condition) {
    if (condition.equals("nicStartWith90")) {
      return employeeService.nicStartWith90();
    } else if (condition.equals("workingForFiveYears")) {
      return employeeService.workingForFiveYears();
    }
    return new ArrayList<>();
  }

  @GetMapping("name")
  public Employee viewEmployeeByName(@RequestParam String employeeName) {
    return employeeService.viewEmployeeByName(employeeName);
  }

  @GetMapping("department")
  public List<Employee> getEmployeesByDepartmentName(
      @RequestParam Department.DepartmentName departmentName) {
    return employeeService.getEmployeesByDepartmentName(departmentName);
  }

  @PostMapping("")
  public Employee addEmployee(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @PutMapping("")
  public Employee editEmployee(@RequestBody Employee employee) {
    return employeeService.editEmployee(employee);
  }

  @DeleteMapping("")
  public void deleteEmployee(@RequestParam Integer employeeId, @RequestParam Integer departmentId) {
    employeeService.deleteEmployee(employeeId, departmentId);
  }

}
