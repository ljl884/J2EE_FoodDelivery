package com.fooddelivery.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Item {
	private int id;
	private String name;
	private int price;
	private String catagory;//spelling
	private String description;
	private int menuid;
	private int stock;
	
	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	@Id
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	public String getCatagory(){
		return catagory;
	}
	
	public void setCatagory(String catagory){
		this.catagory=catagory;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
