package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.Country;

public interface CountryService {
	
	Integer addCountry(Country obj);

	void deleteCountryById(Integer id);

	Country getCountryById(Integer id);

}
