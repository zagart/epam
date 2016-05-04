package by.grodno.zagart.services;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import by.grodno.zagart.dataaccess.model.Product;
import by.grodno.zagart.services.impl.ProductServiceImpl;

public class ProductServiceTest extends AbstractSpringClass {

	@Autowired
	ProductServiceImpl productService;
	private Integer id;

	@Test
	public void addNewProductTest() {
		Product product = randomProduct();
		id = productService.addNewProduct(product);
		Product testProduct = productService.getProductById(id);
		
		Assert.assertNotNull(testProduct);
		Assert.assertEquals(product, testProduct);
		
		productService.deleteProductById(id);
	}

	public static Product randomProduct() {
		Random rnd = new Random();
		Product product = new Product();
		product.setName(RandomStringUtils.random(rnd.nextInt(100)));
		product.setDescription(RandomStringUtils.random(rnd.nextInt(200)));
		product.setCost(new BigDecimal((double)(rnd.nextInt(1000) + rnd.nextDouble())));
		return product;
	}

}
