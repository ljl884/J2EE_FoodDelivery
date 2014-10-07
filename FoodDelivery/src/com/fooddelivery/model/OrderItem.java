package com.fooddelivery.model;

import org.hibernate.annotations.Entity;

@Entity
public class OrderItem {
	private int id;
	private int itemid;
	private int orderid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	
}
