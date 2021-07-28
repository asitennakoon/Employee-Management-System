package com.thiranya.app.controller;

import com.thiranya.app.model.Department;
import com.thiranya.app.model.Employee;
import java.time.LocalDate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebServiceConsumer {

  static final String REST_SERVICE_URL = "http://localhost:8080/employees";
  RestTemplate restTemplate;

  public WebServiceConsumer(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @RequestMapping("")
  public String renderHomepage() {
    return "homepage";
  }

  @RequestMapping("condition")
  public String searchEmployee(@RequestParam String condition, Model model) {
    Employee[] responses = restTemplate.getForObject(REST_SERVICE_URL + "?condition=" + condition,
        Employee[].class);

    model.addAttribute("employees", responses);
    model.addAttribute("title", condition);
    return "results";
  }

  @RequestMapping("name")
  public String viewEmployeeByName(@RequestParam String employeeName, Model model) {
    Employee response = restTemplate.getForObject(
        REST_SERVICE_URL + "/name?employeeName=" + employeeName,
        Employee.class);

    Employee[] responses = {response};

    model.addAttribute("employees", responses);
    assert response != null;
    model.addAttribute("title", employeeName + " " + response.getLastName());
    return "results";
  }

  @RequestMapping("department")
  public String getEmployeesByDepartmentName(@RequestParam Department.DepartmentName departmentName,
      Model model) {
    Employee[] responses = restTemplate
        .getForObject(REST_SERVICE_URL + "/department?departmentName=" + departmentName,
            Employee[].class);

    model.addAttribute("employees", responses);
    model.addAttribute("title", departmentName);
    return "results";
  }

  @PostMapping("")
  public String addEmployee(Employee employee, String startDate, Model model) {
    employee.setStartDate(LocalDate.parse(startDate));
    HttpEntity<Employee> request = new HttpEntity<>(employee);
    Employee response = restTemplate.postForEntity(REST_SERVICE_URL, request, Employee.class)
        .getBody();
    Employee[] responses = {response};

    model.addAttribute("employees", responses);
    model.addAttribute("title", employee.getFirstName() + " " + employee.getLastName());
    return "results";
  }

  @RequestMapping("edited")
  public String editEmployee(Employee employee, String startDate, Model model) {
    employee.setStartDate(LocalDate.parse(startDate));
    HttpEntity<Employee> request = new HttpEntity<>(employee);
    Employee response = restTemplate.exchange(REST_SERVICE_URL, HttpMethod.PUT, request,
        Employee.class).getBody();
    Employee[] responses = {response};

    model.addAttribute("employees", responses);
    model.addAttribute("title", employee.getFirstName() + " " + employee.getLastName());
    return "results";
  }

  @RequestMapping("deleted")
  public String deleteEmployee(@RequestParam Integer employeeId, @RequestParam Integer departmentId,
      Model model) {
    MultiValueMap<String, Integer> parametersMap = new LinkedMultiValueMap<>();

    parametersMap.add("employeeId", employeeId);
    parametersMap.add("departmentId", departmentId);
    HttpEntity<?> request = new HttpEntity<>(parametersMap);

    restTemplate.exchange(REST_SERVICE_URL, HttpMethod.DELETE, request, String.class);
    return "homepage";
  }

}
