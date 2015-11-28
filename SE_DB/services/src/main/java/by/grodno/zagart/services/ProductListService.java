package by.grodno.zagart.services;

import by.grodno.zagart.dataaccess.model.ProductList;

public interface ProductListService {

	Integer createNewProductList(ProductList list);
	
	ProductList getProductListById(Integer id);
	
	void deleteProductListById(Integer id);
	
	void addToListProductById(Integer id);
	
	void deleteFromListProductById(Integer id);
	
}
