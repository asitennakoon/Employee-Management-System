package com.thiranya.ems.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeDepartmentKey implements Serializable {

    private int employee_id;

    private int department_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeDepartmentKey that = (EmployeeDepartmentKey) o;
        return employee_id == that.employee_id && department_id == that.department_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, department_id);
    }
}
