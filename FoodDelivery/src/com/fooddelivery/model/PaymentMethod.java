package com.fooddelivery.model;

import org.hibernate.annotations.Entity;

@Entity
public class PaymentMethod {
	private int id;
	private String name;
	private int orderid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String method) {
		this.name = method;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
}
