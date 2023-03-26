package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Products;
import com.example.demo.service.ProductsService;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productsService.findAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable("id") int id){
		
		Optional<Products> optProduct= productsService.findProduct(id);
		
		if(optProduct.isPresent()) {
			Products product = optProduct.get();
			
			return new ResponseEntity<Products>(product,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<Products> createProduct(@RequestBody Products inProduct) {
		
		try {
		Products resProduct = productsService.createProduct(inProduct);
		return new ResponseEntity<Products>(resProduct,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> editProduct(@PathVariable("id") int id, @RequestBody Products inProduct) {
		Optional <Products> optProduct= productsService.findProduct(id);
		
		
		if(optProduct.isPresent()) {
			//update the object
			Products product = optProduct.get();
			
			product.setName(inProduct.getName());
			product.setPrice(inProduct.getPrice());
			product.setSize(inProduct.getSize());
			product.setImg(inProduct.getImg());
			
			Products updatedProduct = productsService.editProduct(product);
			
			return new ResponseEntity<Products>(updatedProduct,HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id) {
		try {
		productsService.delProduct(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}