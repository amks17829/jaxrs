package com.webservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.webservice.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static List<Employee> employeeList = new ArrayList<>();
	
	static {
		getAllEmployees();
	}
	
	public static List<Employee> getAllEmployees() {
		Employee e1 = new Employee(1, "Mayur", "Research", "Manager", 200000);
		Employee e2 = new Employee(2, "Anshi", "Research", "Developer", 50000);
		Employee e3 = new Employee(3, "Om", "HR", "Recruiter", 10000);
		Employee e4 = new Employee(4, "Chaitrali", "Admin", "Manager", 40000);
		Employee e5 = new Employee(5, "DJ", "Admin", "Director", 115000);
		Employee e6 = new Employee(6, "Aditi", "HR", "Finance", 40000);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		employeeList.add(e6);
		return employeeList;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp = employeeList.stream().filter(e->e.getId()==id).findFirst();
		return emp.get();
	}

	@Override
	public List<Employee> getEmployeeByDept(String dept) {
		List<Employee> eList = employeeList.stream().filter(e -> e.getDepartment().equals(dept)).collect(Collectors.toList());
		
		return eList;
	}

	@Override
	public List<Employee> getEmployeeInSalaryRange(double minsalary, double maxsalary) {
		List<Employee> eList = employeeList.stream().filter(e->e.getSalary()>=minsalary&&e.getSalary()<=maxsalary).collect(Collectors.toList());
		return eList;
	}

	@Override
	public List<Employee> getEmployeeByDeptAndSalary(String dept, double salary) {
		List<Employee> eList = employeeList.stream().filter(e->e.getSalary()>=salary&&e.getDepartment().equals(dept)).collect(Collectors.toList());
		return eList;
	}

	@Override
	public List<Employee> getEmployeeByDeptOrJob(String dept, String job) {
		List<Employee> eList = employeeList.stream().filter(e->e.getJob().equals(job)||e.getDepartment().equals(dept)).collect(Collectors.toList());
		return eList;
	}
	
	

}
