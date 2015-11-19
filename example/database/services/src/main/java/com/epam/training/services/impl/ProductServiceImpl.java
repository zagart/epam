package com.epam.training.services.impl;

import org.springframework.stereotype.Service;

import com.epam.training.dataaccess.dao.ProductDao;
import com.epam.training.dataaccess.dao.impl.ProductDaoImpl;
import com.epam.training.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDaoImpl = new ProductDaoImpl();

}
