package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.dao.BookDAO;
import com.cts.dao.ProductDAO;
import com.cts.entity.Book;
import com.cts.entity.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDao;
	
	@Override
	@Transactional
	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	@Transactional
	@Override
	public void createProduct(Product product) {
		productDao.addProduct(product);	
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDao.getProduct(id);
		 
	}

	
	

}
