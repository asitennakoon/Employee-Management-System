package com.thiranya.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "department")
public class Department {
	public enum DepartmentName {
		ENGINEERING, IMPLEMENTATION, SUPPORT, BS, MARKETING, HR
	}

	@Id
	@Column(length = 2, nullable = false, unique = true)
	private int departmentId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private DepartmentName departmentName;

	@OneToMany(mappedBy = "department")
	@JsonManagedReference
	private List<Employee> employees;

	public Department() {
	}

	public Department(int departmentId, DepartmentName departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public DepartmentName getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(DepartmentName departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
