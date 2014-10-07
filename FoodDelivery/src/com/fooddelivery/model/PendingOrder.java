package com.fooddelivery.model;

import java.util.ArrayList;

public class PendingOrder {
	private int id;
	private int restaurantid;
	private Order order;
	private ArrayList<OrderItem> orderItems;
	private CustomerInfo customerInfo;
	private DeliverAddress deliverAddress;
	private PaymentMethod paymentMethod;
	
	public PendingOrder(Order order, ArrayList<OrderItem> orderItems,CustomerInfo customerInfo,DeliverAddress deliverAddress,PaymentMethod paymentMethod){
		
		this.order = order;
		this.orderItems=orderItems;
		this.customerInfo=customerInfo;
		this.deliverAddress=deliverAddress;
		this.paymentMethod=paymentMethod;
		this.id = order.getId();
		this.restaurantid = order.getRestaurantid();
	}
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

}
