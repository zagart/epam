package by.grodno.zagart.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grodno.zagart.dataaccess.dao.impl.ProductListDaoImpl;
import by.grodno.zagart.dataaccess.model.ProductList;
import by.grodno.zagart.services.ProductListService;

/**
 * Implementation of product list service that executes product list model
 * methods.
 * 
 * @author zagart
 *
 */
@Service
public class ProductListServiceImpl implements ProductListService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductListServiceImpl.class);

	@Autowired
	ProductListDaoImpl productListDao;

	/**
	 * Method for creating new product list.
	 */
	@Override
	public Integer createNewProductList(ProductList list) {
		Integer id = productListDao.insert(list);
		LOGGER.info("Product list with id = {} added.", id);
		return id;
	}

	/**
	 * Method for getting product list by id.
	 */
	@Override
	public ProductList getProductListById(Integer id) {
		ProductList productList = productListDao.getById(id);
		LOGGER.info("Product with id = {} received.", id);
		return productList;
	}

	/**
	 * Method for deleting product list by id.
	 */
	@Override
	public void deleteProductListById(Integer id) {
		productListDao.deleteById(id);
		LOGGER.info("Product list with id = {} deleted.", id);
	}

	/**
	 * Method for add new product to existing product list.
	 */
	@Override
	public void addToListProductById(Integer id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method for deleting product from product list with pointed id.
	 */
	@Override
	public void deleteFromListProductById(Integer id) {
		// TODO Auto-generated method stub

	}

}
