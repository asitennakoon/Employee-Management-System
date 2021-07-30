package com.thiranya.ems.repository;

import com.thiranya.ems.model.EmployeeData;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeData, Integer> {

    Iterable<Optional<EmployeeData>> findByNicIsStartingWith(String prefix);

    @Query(value = "SELECT * FROM employee WHERE start_date < ?1", nativeQuery = true)
    Iterable<Optional<EmployeeData>> findByStart_dateBefore(LocalDate date);

    @Query(value = "SELECT * FROM employee WHERE first_name = ?1 OR last_name = ?2", nativeQuery = true)
    Iterable<Optional<EmployeeData>> findByFirst_nameOrLast_name(String firstName, String lastName);

}
