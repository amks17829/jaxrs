package com.webservice.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.webservice.dao.CountryDao;
import com.webservice.dao.CountryDaoImpl;
import com.webservice.model.Country;
import com.webservice.model.Response;

@Path("/countryservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountryServiceImpl implements CountryService {
	
	CountryDao countryDao = new CountryDaoImpl();

	@Override
	@GET
	@Path("/country")
	public Country getCountryIndia() {
		System.out.println("asdf");
		Optional<Country> country = countryDao.getCountryByCode("IN");
		System.out.println("asdf:"+country.get().getName());
		return country.get();
	}
	
	
	
	@Override
	@POST
	@Path("/add")
	public Response addCountry(Country country) {
		Response res = new Response();
		boolean status = countryDao.addCountry(country);
		if(status) {
			res.setMessage("Country added successfully");
		}
		else {
			res.setMessage("Couldn't add country");
		}
		res.setStatus(status);
		return res;
	}



	@Override
	@GET
	@Path("/countries")
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}



	@Override
	@DELETE
	@Path("/countries/{code}")
	public Response deleteCountry(@PathParam("code") String code) {
		Response res = new Response();
		if(countryDao.deleteCountry(code)) {
			res.setMessage("Country:"+code+" deleted successfully");
			res.setStatus(true);
		}
		else {
			res.setMessage("Couldn't delete");
			res.setStatus(false);
		}
		return res;
	}



	@Override
	@GET
	@Path("/countries/{code}")
	public Country getCountry(@PathParam("code") String code) {
		Optional<Country> country = countryDao.getCountryByCode(code);
		return country.get();
	}



	@Override
	@GET
	@Path("/cname")
	public Country getCountryByName(@MatrixParam("name") String name) {
		
		return countryDao.getCountryByName(name);
	}
	
	

}
