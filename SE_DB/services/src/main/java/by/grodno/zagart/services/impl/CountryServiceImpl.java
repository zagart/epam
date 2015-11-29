package by.grodno.zagart.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.impl.CountryDaoImpl;
import by.grodno.zagart.dataaccess.model.Country;
import by.grodno.zagart.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDaoImpl countryDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	@Override
	public void deleteCountryById(Integer id) {
		countryDao.deleteById(id);
		LOGGER.info("Deleted country with id = {}.", id);
	}

	@Override
	public Country getCountryById(Integer id) {
		LOGGER.info("Received country with id = {}.", id);
		return countryDao.getById(id);
	}

	@Override
	public Integer addCountry(Country country) {
		int id = countryDao.insert(country);
		LOGGER.info("Added new country with id = {}.", id);
		return id;
	}

}
