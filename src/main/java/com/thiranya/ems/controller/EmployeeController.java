package com.thiranya.ems.controller;

import com.thiranya.ems.model.Employee;
import com.thiranya.ems.repository.model.DepartmentData;
import com.thiranya.ems.repository.model.EmployeeData;
import com.thiranya.ems.service.EmployeeService;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;

    public EmployeeController(EmployeeService employeeService,
            EmployeeConverter employeeConverter) {
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
    }

    @GetMapping("employees")
    public String viewEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) DepartmentData.DepartmentName department,
            @RequestParam(required = false) String condition,
            Model model) {
        List<EmployeeData> employees = Collections.emptyList();
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

        model.addAttribute("employees", employeeConverter.convertToDtoList(employees));
        model.addAttribute("title", title);
        return "results";
    }

    @PostMapping("added")
    public String addEmployee(Employee employee, Model model) {
        EmployeeData employeeData = employeeConverter.convertToEntity(employee);
        EmployeeData addedEmployee = employeeService.addEmployee(employeeData);

        employeeService.addEmpDepEntry(addedEmployee.getEmployeeId(), employee.getDepartmentId());

        Employee employeeDto = employeeConverter.convertToDto(addedEmployee);
        List<Employee> employees = Collections.singletonList(employeeDto);

        model.addAttribute("employees", employees);
        model.addAttribute("title", employee.getFirstName() + " " + employee.getLastName());
        return "results";
    }

    @GetMapping("edit")
    public String getExistingEmployee(Integer employeeId, Model model) {
        EmployeeData employeeData = employeeService.findById(employeeId).orElse(null);
        Employee existingEmployeeDto = null;

        if (employeeData != null) {
            existingEmployeeDto = employeeConverter.convertToDto(employeeData);
            model.addAttribute("title", "Updating info of " + existingEmployeeDto.getFirstName());
        } else {
            model.addAttribute("title", "Employee not found!");
        }

        model.addAttribute("employee", existingEmployeeDto);
        return "update_form";
    }

    @PostMapping("updated")
    public String editEmployee(Employee employee, Model model) {
        EmployeeData employeeData = employeeConverter.convertToEntity(employee);
        EmployeeData editedEmployee = employeeService.editEmployee(employeeData);

        employeeService.addEmpDepEntry(editedEmployee.getEmployeeId(), employee.getDepartmentId());

        Employee employeeDto = employeeConverter.convertToDto(editedEmployee);
        List<Employee> employees = Collections.singletonList(employeeDto);

        model.addAttribute("employees", employees);
        model.addAttribute("title", "Updated info of " + editedEmployee.getFirstName());
        return "results";
    }

    @PostMapping("deleted")
    public String deleteEmployee(@RequestParam Integer employeeId, Model model) {
        employeeService.deleteEmployee(employeeId);
        return "homepage";
    }

}
