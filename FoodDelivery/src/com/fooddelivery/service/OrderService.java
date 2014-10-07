package com.fooddelivery.service;

import java.util.ArrayList;

import com.fooddelivery.datasource.CustomerInfoMapper;
import com.fooddelivery.datasource.DeliverAddressMapper;
import com.fooddelivery.datasource.OrderItemMapper;
import com.fooddelivery.datasource.OrderMapper;
import com.fooddelivery.datasource.PaymentMethodMapper;
import com.fooddelivery.model.CustomerInfo;
import com.fooddelivery.model.DeliverAddress;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.OrderItem;
import com.fooddelivery.model.PaymentMethod;
import com.fooddelivery.model.PendingOrder;

public class OrderService {
	
	public int createOrder(PendingOrder order){
		return createOrder(order.getRestaurantid(), order.getOrderItems(), order.getCustomerInfo(), order.getPaymentMethod(), order.getDeliverAddress());
		
	}
	
	public int createOrder(int restaurantId,ArrayList<OrderItem> orderItems, CustomerInfo customerInfo, PaymentMethod paymentMethod, DeliverAddress deliverAddress){
		Order order = new Order();
		order.setRestaurantid(restaurantId);
		order.setStatus("new");		
		int id = OrderMapper.insert(order);
		customerInfo.setOrderid(id);
		CustomerInfoMapper.insert(customerInfo);
		paymentMethod.setOrderid(id);
		PaymentMethodMapper.insert(paymentMethod);
		deliverAddress.setOrderid(id);
		DeliverAddressMapper.insert(deliverAddress);
		return id;
	}
	
	public void deleteOrder(int id){
		
	}
	
	public PendingOrder getOrder(int id){
		Order order = OrderMapper.getOrder(id);
		CustomerInfo customerInfo = CustomerInfoMapper.getCustomerInfoByOrderId(id);
		DeliverAddress deliverAddress = DeliverAddressMapper.getDeliverAddressByOrderId(id);
		PaymentMethod paymentMethod = PaymentMethodMapper.getPaymentMethodByOrderId(id);
		ArrayList<OrderItem> orderItems =(ArrayList<OrderItem>)OrderItemMapper.getOrderItemsByOrderId(id);
		PendingOrder pendingOrder = new PendingOrder(order, orderItems, customerInfo, deliverAddress, paymentMethod);
		return pendingOrder;
	}
	
	public boolean isOrderConfirmed(int id){
		Order order = OrderMapper.getOrder(id);
		if (order!=null) {
			if(order.getStatus().equals("confirmed"))
				return true;
		}
		return false;
	}
	
	public void confirmOrder(int id){
		Order order = OrderMapper.getOrder(id);
		if (order!=null) {
			order.setStatus("confirmed");
		}
		
	}

}
