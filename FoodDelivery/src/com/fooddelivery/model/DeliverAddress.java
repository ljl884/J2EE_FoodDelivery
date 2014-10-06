package com.fooddelivery.model;

import org.hibernate.annotations.Entity;

@Entity
public class DeliverAddress {
	private int id;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}	
