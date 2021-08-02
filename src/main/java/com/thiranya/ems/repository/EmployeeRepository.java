package com.thiranya.ems.repository;

import com.thiranya.ems.repository.model.EmployeeData;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeData, Integer> {

    List<EmployeeData> findByNicIsStartingWith(String prefix);

    List<EmployeeData> findByStartDateBefore(LocalDate year);

    List<EmployeeData> findByFirstNameOrLastName(String firstName, String lastName);

    @Query(value = "SELECT employee.* FROM employee, department, employee_department WHERE department_name = ?1 AND department.department_id=employee_department.department_id AND employee.employee_id=employee_department.employee_id", nativeQuery = true)
    List<EmployeeData> getEmployeesByDepartmentName(String departmentName);

    @Query(value = "SELECT EXISTS(SELECT * FROM employee_department WHERE employee_id = ?1 AND department_id = ?2)", nativeQuery = true)
    Integer findEntry(Integer employeeId, Integer departmentId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee_department(employee_id, department_id) VALUES (?1,?2)", nativeQuery = true)
    void insertEmpDepEntry(Integer employeeId, Integer departmentId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET first_name = ?1, last_name = ?2, mobile_number = ?3, designation = ?4 WHERE employee_id = ?5", nativeQuery = true)
    void updateEmployee(String fName, String lName, String mobileNumber, String designation,
            Integer id);

}
