package com.thiranya.ems.repository;

import com.thiranya.ems.model.DepartmentData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentData, Integer> {

}
