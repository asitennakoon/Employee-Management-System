package com.thiranya.app.model;

import java.io.Serializable;
import java.util.Objects;

public class EmployeePrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private int departmentId;

	public EmployeePrimaryKey() {
	}

	public EmployeePrimaryKey(int employeeId, int departmentId) {
		this.employeeId = employeeId;
		this.departmentId = departmentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId, employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePrimaryKey other = (EmployeePrimaryKey) obj;
		return departmentId == other.departmentId && employeeId == other.employeeId;
	}

}
