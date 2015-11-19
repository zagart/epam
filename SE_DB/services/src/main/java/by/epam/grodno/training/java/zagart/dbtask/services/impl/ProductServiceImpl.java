package by.epam.grodno.training.java.zagart.dbtask.services.impl;

import org.springframework.stereotype.Service;

import by.epam.grodno.training.java.zagart.dbtask.dao.ProductDao;
import by.epam.grodno.training.java.zagart.dbtask.dao.impl.ProductDaoImpl;
import by.epam.grodno.training.java.zagart.dbtask.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDaoImpl = new ProductDaoImpl();

}
