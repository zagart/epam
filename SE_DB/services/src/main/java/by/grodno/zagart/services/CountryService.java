package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.Country;

public interface CountryService {
	
	void insert(Country obj);

	void deleteById(Integer id);

	Country getById(Integer id);

}
