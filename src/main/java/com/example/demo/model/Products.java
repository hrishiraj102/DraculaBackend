package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Products {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String size;
	private String price;
	private String img;
	
	public Products() {
		
	}
	
	public Products(String name,String size,String price,String img) {
		this.name= name;
		this.size= size;
		this.price=price;
		this.img= img;
		
	}
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", size=" + size + ", price=" + price + ", img=" + img + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}
