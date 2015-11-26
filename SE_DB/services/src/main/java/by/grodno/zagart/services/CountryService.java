package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.Country;

public interface CountryService {
	
	void insert(Country obj);

	void deleteById(Long id);

	Country getById(Long id);

}
