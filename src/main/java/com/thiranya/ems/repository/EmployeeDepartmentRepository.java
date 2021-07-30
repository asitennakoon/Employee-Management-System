package com.thiranya.ems.repository;

import com.thiranya.ems.model.DepartmentData;
import com.thiranya.ems.model.EmployeeDepartmentData;
import com.thiranya.ems.model.EmployeeDepartmentKey;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDepartmentRepository extends
        CrudRepository<EmployeeDepartmentData, EmployeeDepartmentKey> {

    @Query(value = "SELECT DISTINCT employee_id FROM employee_department_data WHERE department_id = ?1", nativeQuery = true)
    List<Integer> getEmployeeIdsOfDepartment(DepartmentData.DepartmentName departmentName);

}
