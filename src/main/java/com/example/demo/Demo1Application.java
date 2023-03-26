package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductsRepository;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@Bean
	CommandLineRunner loadData(ProductsRepository productsRepository) {
		return (args) -> {
			//Add some products for testing
			Products product1 = new Products();
			product1.setName("T shirt");
			product1.setPrice("399");
			product1.setSize("XL");
			product1.setImg("https://media.istockphoto.com/id/488160041/photo/mens-shirt.jpg?s=612x612&w=0&k=20&c=xVZjKAUJecIpYc_fKRz_EB8HuRmXCOOPOtZ-ST6eFvQ=");
			
			productsRepository.save(product1);
			
			Products product2 = new Products();
			product2.setName("shirt");
			product2.setPrice("399");
			product2.setSize("L");
			product2.setImg("https://media.istockphoto.com/id/488160041/photo/mens-shirt.jpg?s=612x612&w=0&k=20&c=xVZjKAUJecIpYc_fKRz_EB8HuRmXCOOPOtZ-ST6eFvQ=");
			
			productsRepository.save(product2);
			
		};
	}

}
