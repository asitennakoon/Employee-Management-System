package com.thiranya.app.repository;

import com.thiranya.app.model.Employee;
import com.thiranya.app.model.EmployeePrimaryKey;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, EmployeePrimaryKey> {

  @Query(value = "SELECT * FROM employee WHERE nic LIKE '90%'", nativeQuery = true)
  List<Employee> nicStartWith90();

  @Query(value = "SELECT * FROM employee WHERE timestampdiff(YEAR, start_Date, now()) > 5", nativeQuery = true)
  List<Employee> workingForFiveYears();

  @Query(value = "SELECT * FROM employee WHERE first_name = ?1", nativeQuery = true)
  Employee viewEmployeeByName(String employeeName);

  @Query(value = "SELECT employee.* FROM employee, department WHERE department_name = ?1 AND department.department_id = employee.department_id", nativeQuery = true)
  List<Employee> getEmployeesByDepartmentName(String departmentName);

  @Query(value = "SELECT * from employee WHERE employee_id = ?1 AND department_id = ?2", nativeQuery = true)
  Employee findByPrimaryKey(Integer employeeId, Integer departmentId);

}
