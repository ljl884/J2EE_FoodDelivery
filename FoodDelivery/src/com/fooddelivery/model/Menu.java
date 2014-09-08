package com.fooddelivery.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	
	private int id;
	private String name;
	private int restaurantid;
	
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
	
	public int getRestaurantid(){
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid){
		this.restaurantid=restaurantid;
	}
}
