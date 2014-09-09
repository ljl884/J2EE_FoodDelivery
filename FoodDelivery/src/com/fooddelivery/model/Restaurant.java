package com.fooddelivery.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurant {
	private int id;
	private String name;
	private String category;
	private String location;
	private int averageprice;
	
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
	public void setName(String name) {
		this.name=name;
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category=category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAverageprice() {
		return averageprice;
	}

	public void setAverageprice(int averageprice) {
		this.averageprice = averageprice;
	}
}
