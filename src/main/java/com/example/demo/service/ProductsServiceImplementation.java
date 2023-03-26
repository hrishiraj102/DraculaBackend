package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductsRepository;

import jakarta.annotation.Resource;


@Service
@Transactional (readOnly = true)
public class ProductsServiceImplementation implements ProductsService {
	@Resource
	private ProductsRepository productsRepository;   //Call repository and declare it as resourse 
	
	
	@Override
	public List<Products> findAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public Optional<Products> findProduct(int id) {
		return productsRepository.findById(id);
	}

	@Transactional (readOnly = false)
	@Override
	public Products createProduct(Products product) {
		// TODO Auto-generated method stub
		return productsRepository.save(product);
	}

	@Transactional (readOnly = false)
	@Override
	public Products editProduct(Products product) {
		return productsRepository.save(product);
	}

	@Transactional (readOnly = false)
	@Override
	public void delProduct(int id) {
		productsRepository.deleteById(id);
		
	}

	
	
}
