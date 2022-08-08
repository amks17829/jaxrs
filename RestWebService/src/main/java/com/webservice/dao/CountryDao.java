package com.webservice.dao;

import java.util.List;
import java.util.Optional;

import com.webservice.model.Country;

public interface CountryDao {
	
	public Optional<Country> getCountryByCode(String code);
	
	public boolean addCountry(Country country);
	
	public Country getCountryByName(String name);
	
	public List<Country> getAllCountries();
	
	public boolean deleteCountry(String code);
	
}
