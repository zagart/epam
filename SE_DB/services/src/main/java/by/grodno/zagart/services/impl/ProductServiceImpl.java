package by.grodno.zagart.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.impl.ProductDaoImpl;
import by.grodno.zagart.dataaccess.model.Product;
import by.grodno.zagart.services.ProductService;

/**
 * Implementation of product service interface that uses product model.
 * 
 * @author zagart
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDaoImpl productDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	/**
	 * Method for adding new product.
	 */
	@Override
	public Integer addNewProduct(Product product) {
		Integer id = productDao.insert(product);
		LOGGER.info("Product with id = {} added.", id);
		return id;
	}

	/**
	 * Method for deleting product by id.
	 */
	@Override
	public void deleteProductById(Integer id) {
		productDao.deleteById(id);
		LOGGER.info("Product with id = {} deleted.", id);
	}

	/**
	 * Method for getting product by id.
	 */
	@Override
	public Product getProductById(Integer id) {
		Product product = productDao.getById(id);
		LOGGER.info("Product with id = {} received.", id);
		return product;
	}

}
