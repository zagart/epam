package by.grodno.zagart.services.impl;

import org.springframework.stereotype.Service;


import by.grodno.zagart.dataaccess.dao.ProductDao;
import by.grodno.zagart.dataaccess.dao.impl.ProductDaoImpl;
import by.grodno.zagart.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDaoImpl = new ProductDaoImpl();

}
