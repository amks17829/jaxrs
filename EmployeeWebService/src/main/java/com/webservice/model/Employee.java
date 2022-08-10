package com.webservice.model;

public class Employee {
	
	private int id;
	private String name;
	private String Department;
	private String job;
	private double salary;
	
	public Employee(int id, String name, String department, String job, double salary) {
		super();
		this.id = id;
		this.name = name;
		Department = department;
		this.job = job;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Department=" + Department + ", job=" + job + ", salary="
				+ salary + "]";
	}
	
	

}
