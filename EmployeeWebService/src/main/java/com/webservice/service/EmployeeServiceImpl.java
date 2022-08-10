package com.webservice.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.webservice.dao.EmployeeDao;
import com.webservice.dao.EmployeeDaoImpl;
import com.webservice.model.Employee;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/empservice")
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	@GET
	@Path("/employees")
	public List<Employee> getAllEmployees() {
		return empDao.getEmployees();
	}
	
	@Override
	@GET
	@Path("/employees/{id}")
	public Employee getEmployeeById(@PathParam("id") int id) {
		return empDao.getEmployeeById(id);
	}
	
	@Override
	@GET
	@Path("/empbydept")
	public List<Employee> getEmployeeByDept(@QueryParam("dept") String dept) {
		return empDao.getEmployeeByDept(dept);
	}
	
	@Override
	@GET
	@Path("/empbysalaryrange")
	public List<Employee> getEmployeeInSalaryRange(@MatrixParam("minsalary") double minsalary, @MatrixParam("maxsalary") double maxsalary) {
		return empDao.getEmployeeInSalaryRange(minsalary, maxsalary);
	}
	
	@Override
	@GET
	@Path("/empbydeptsalary")
	public List<Employee> getEmployeeByDeptAndSalary(@QueryParam("dept") String dept, @QueryParam("salary") double salary) {
		return empDao.getEmployeeByDeptAndSalary(dept, salary);
	}
	
	@Override
	@GET
	@Path("/empbydeptorjob")
	public List<Employee> getEmployeeByDeptOrJob(@MatrixParam("dept") String dept, @MatrixParam("job") String job) {
		return empDao.getEmployeeByDeptOrJob(dept, job);
	}

}
