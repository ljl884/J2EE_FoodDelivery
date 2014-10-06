package com.fooddelivery.model;

import java.util.ArrayList;

import org.hibernate.annotations.Entity;

@Entity
public class Order {
	private int id;
	private ArrayList<OrderItem> orderItems;
	private CustomerInfo customerInfo;
	private DeliverAddress deliverAddress;
	private PaymentMethod paymentMethod;
	private boolean confirmed = false;
	
	public Order(ArrayList<OrderItem> orderItems, CustomerInfo customerInfo,DeliverAddress deliverAddress,PaymentMethod paymentMethod){
		this.orderItems = orderItems;
		this.customerInfo = customerInfo;
		this.deliverAddress = deliverAddress;
		this.paymentMethod = paymentMethod;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public DeliverAddress getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(DeliverAddress deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public boolean isConfirmed(){
		return confirmed;
	}
	
	public void confirm(){
		confirmed = true;
	}
}
