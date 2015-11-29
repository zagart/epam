package by.grodno.zagart.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
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
		getProductByIdTest();
		deleteProductByIdTest();
	}

	public static Product randomProduct() {
		Random rnd = new Random();
		Product product = new Product();
		product.setName(RandomStringUtils.random(rnd.nextInt(100)));
		product.setDescription(RandomStringUtils.random(rnd.nextInt(200)));
		product.setCost(new BigDecimal((double)(rnd.nextInt(1000) + rnd.nextDouble())));
		product.setShopId(null);
		product.setDeliverCost(new BigDecimal((double)(rnd.nextInt(100) + rnd.nextDouble())));
		product.setProductsQuantityLeft(Math.abs(rnd.nextInt(1000)));
		product.setRating((short) rnd.nextInt(5));
		return product;
	}

	public void getProductByIdTest() {
		productService.getProductById(id);
	}

	public void deleteProductByIdTest() {
		productService.deleteProductById(id);
	}

}
