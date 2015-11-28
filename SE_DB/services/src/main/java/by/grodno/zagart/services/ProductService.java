package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.Product;

public interface ProductService {
	
	Integer addNewProduct(Product product);
	
	void deleteProductById(Integer id);
	
	Product getProductById(Integer id);

}
