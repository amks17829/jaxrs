package com.webservice.service;

import java.util.List;

import com.webservice.model.Country;
import com.webservice.model.Response;

public interface CountryService {
	
	public Country getCountryIndia();
	
	public Response addCountry(Country country);
	
	public List<Country> getAllCountries();
	
	public Response deleteCountry(String code);
	
	public Country getCountry(String code);
	
	public Country getCountryByName(String name);

}
