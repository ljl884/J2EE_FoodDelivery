package com.fooddelivery.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order{
	private int id;
	private int restaurantid;
	private String status;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}