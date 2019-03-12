package com.cts.dao;

import java.util.List;

import com.cts.entity.Product;

public interface ProductDAO {
	
	void addProduct(Product product);
	List<Product>getProductList();
	Product getProduct(int id);
	void deleteProduct(int id);
	void updateProduct(Product product);
	
}
