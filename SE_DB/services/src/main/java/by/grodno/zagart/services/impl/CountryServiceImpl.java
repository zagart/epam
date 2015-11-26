package by.grodno.zagart.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.impl.CountryDaoImpl;
import by.grodno.zagart.dataaccess.model.Country;
import by.grodno.zagart.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDaoImpl countryDao;
	
	
	@Override
	public void deleteById(Long id) {
		countryDao.deleteById(id);
	}

	@Override
	public Country getById(Long id) {
		return countryDao.getById(id);
	}

	@Override
	public void insert(Country country) {
		countryDao.insert(country);
	}

}
