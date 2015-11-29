package by.grodno.zagart.services;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.grodno.zagart.dataaccess.model.Country;
import by.grodno.zagart.services.impl.CountryServiceImpl;

/**
 * Class for testing CountryService methods which use JUnit tests.
 * 
 * @author zagart
 *
 */
public class CountryServiceTest extends AbstractSpringClass {

	@Autowired
	private CountryServiceImpl countryService;
	private static Integer id;

	@Test
	public void countryInsertTest() {
		Country country = randomCountry();
		id = countryService.addCountry(country);
		Country testCountry = countryGetByIdTest();
		
		Assert.assertNotNull(testCountry);
		
		countryDeleteByIdTest();
	}

	public static Country randomCountry() {
		Random rnd = new Random();
		Country country = new Country();
		String randomName = RandomStringUtils.random(rnd.nextInt(20));
		int randomIsoCode = Math.abs(rnd.nextInt(1000));
		country.setName(randomName);
		country.setIsoCode(randomIsoCode);
		return country;
	}

	public Country countryGetByIdTest() {
		return countryService.getCountryById(id);
	}

	public void countryDeleteByIdTest() {
		countryService.deleteCountryById(id);
	}

}
