package com.webservice.dao;

import java.util.List;

import com.webservice.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();

	public Employee getEmployeeById(int id);

	public List<Employee> getEmployeeByDept(String dept);

	public List<Employee> getEmployeeInSalaryRange(double minsalary, double maxsalary);

	public List<Employee> getEmployeeByDeptAndSalary(String dept, double salary);

	public List<Employee> getEmployeeByDeptOrJob(String dept, String job);

}
