package com.cts.service;

import java.util.List;

import com.cts.entity.Book;
import com.cts.entity.Product;

public interface ProductService {

	 List<Product> getProductList();
	 void createProduct(Product product);
	 void deleteProduct(int id);
	 Product getProduct(int id);
	
}
