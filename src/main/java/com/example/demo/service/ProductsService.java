package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Products;

public interface ProductsService {
	
	List<Products> findAllProducts();  //list of all the rows/elements
	
	Optional<Products> findProduct(int id);  
	
	Products createProduct(Products product);
	
	Products editProduct(Products product);
	
	void delProduct(int id);
	
	

}
