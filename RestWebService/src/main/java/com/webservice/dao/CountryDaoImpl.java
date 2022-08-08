package com.webservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.webservice.model.Country;

public class CountryDaoImpl implements CountryDao {
	
	private static List<Country> allCountries = new ArrayList<Country>();;
	
	public CountryDaoImpl() {
		System.out.println("Inside constructor");
	}
	
	static {
		
		Country ind = new Country();
		ind.setCode("IN");
		ind.setName("India");
		
		Country us = new Country();
		us.setCode("USA");
		us.setName("United States of America");
		
		Country esp = new Country();
		esp.setCode("ESP");
		esp.setName("Spain");
		
		allCountries.add(ind);
		allCountries.add(us);
		allCountries.add(esp);
		
		System.out.println("Inside static block");
	}

	@Override
	public Optional<Country> getCountryByCode(String code) {
		Optional<Country> country = allCountries.stream().filter(con->con.getCode().equals(code)).findFirst();
		System.out.println("sdf:"+country);
		return country;
	}

	@Override
	public boolean addCountry(Country country) {
		boolean res = allCountries.add(country);
		System.out.println(allCountries);
		return res;
	}

	@Override
	public Country getCountryByName(String name) {
		Optional<Country> res = allCountries.stream().filter(c -> c.getName().equals(name)).findFirst();
		return res.get();
	}

	@Override
	public List<Country> getAllCountries() {
		System.out.println("GetallCountries:"+allCountries);
		return allCountries;
	}

	@Override
	public boolean deleteCountry(String code) {
		return allCountries.removeIf(e->e.getCode().equals(code));
	}
	
	

}
