package com.fooddelivery.datasource;

import com.fooddelivery.model.OrderItem;

public class OrderItemMapper extends DataMapper{
	public static int insert(OrderItem orderItem){
		int id = -1;
		init();
		if(orderItem!=null){
			session.save(orderItem);
			id = orderItem.getId();
		}
		close();
		return id;
	}
	
	public static OrderItem getOrderItem(int id){
		init();
		OrderItem result = (OrderItem) session.load(OrderItem.class, id);
		close();
		return result;
	}
}
