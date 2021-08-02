package com.thiranya.ems.controller;

import com.thiranya.ems.model.DepartmentData;
import com.thiranya.ems.model.Employee;
import com.thiranya.ems.model.EmployeeData;
import com.thiranya.ems.service.EmployeeService;
import java.util.Collections;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private static final String VIEW = "results";
    private static final String RESPONSE = "employees";
    private static final String TITLE = "title";
    private final EmployeeService employeeService;
    private final DtoConverter dtoConverter;

    public EmployeeController(EmployeeService employeeService, DtoConverter dtoConverter) {
        this.employeeService = employeeService;
        this.dtoConverter = dtoConverter;
    }

    @RequestMapping("")
    public String renderHomepage() {
        return "homepage";
    }

    @GetMapping("employees")
    public String viewEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) DepartmentData.DepartmentName department,
            @RequestParam(required = false) String condition,
            Model model) {
        Iterable<EmployeeData> employees = Collections.emptyList();
        String title = "No entries found";

        if (name != null) {
            employees = employeeService.viewEmployeesByName(name);
            title = "Employees named " + name;
        } else if (department != null) {
            employees = employeeService.getEmployeesByDepartmentName(department);
            title = "Employees in " + department;
        } else if (condition.equals("nicStartWith90")) {
            employees = employeeService.nicStartWith90("90");
            title = "Employees whose NIC starts with 90";
        } else if (condition.equals("workingForFiveYears")) {
            employees = employeeService.workingForFiveYears(5);
            title = "Employees working for more than 5 years";
        }

        model.addAttribute(RESPONSE, dtoConverter.convertIterableToDtoList(employees));
        model.addAttribute(TITLE, title);
        return VIEW;
    }

    @PostMapping("")
    public String addEmployee(Employee employee, Model model) {
        EmployeeData employeeData = dtoConverter.convertToEntity(employee);
        EmployeeData addedEmployee = employeeService.addEmployee(employeeData);

        employeeService.addEmpDepEntry(addedEmployee.getEmployee_id(), employee.getDepartmentId());

        Employee employeeDto = dtoConverter.convertToDto(addedEmployee);
        Iterable<Employee> employees = Collections.singleton(employeeDto);

        model.addAttribute(RESPONSE, employees);
        model.addAttribute(TITLE, employee.getFirstName() + " " + employee.getLastName());
        return VIEW;
    }

    @PostMapping("edited")
    public String editEmployee(Employee employee, Model model) {
        EmployeeData employeeData = dtoConverter.convertToEntity(employee);
        EmployeeData editedEmployee = employeeService.editEmployee(employeeData);

        employeeService.addEmpDepEntry(editedEmployee.getEmployee_id(), employee.getDepartmentId());

        Employee employeeDto = dtoConverter.convertToDto(editedEmployee);
        Iterable<Employee> employees = Collections.singleton(employeeDto);

        model.addAttribute(RESPONSE, employees);
        model.addAttribute(TITLE, "Updated info of " + editedEmployee.getFirst_name());
        return VIEW;
    }

    @PostMapping("deleted")
    public String deleteEmployee(@RequestParam Integer employeeId, Model model) {
        employeeService.deleteEmployee(employeeId);
        return "homepage";
    }

}
