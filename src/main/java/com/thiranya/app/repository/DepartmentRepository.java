package com.thiranya.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.thiranya.app.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
