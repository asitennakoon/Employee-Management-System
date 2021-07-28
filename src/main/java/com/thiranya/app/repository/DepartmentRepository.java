package com.thiranya.app.repository;

import com.thiranya.app.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
