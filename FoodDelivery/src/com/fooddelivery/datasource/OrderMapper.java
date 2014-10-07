package com.fooddelivery.datasource;



import java.util.ArrayList;

import org.hibernate.Query;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.Menu;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderMapper extends DataMapper {
	
	public static int insert(Order order){
		int id = -1;
		init();
		if(order!=null){
			session.save(order);
			id=order.getId();
		}
		close();
		return id;
	}
	
	public static void delete(int id){
		init();
		Order order = (Order)session.load(Order.class, id);
		session.delete(order);
		close();
	}
	
	public static Order getOrder(int id){
		init();
		Order item = (Order)session.get(Order.class, id);
		close();
		return item;
		}
	
	public static int getRestaurantId(int orderid){
		int restaurantid=-1;
		init();
		Order order = (Order)session.load(Order.class, orderid);
		if (order!=null) {
			restaurantid = order.getRestaurantid();
		}
		
		close();
		return restaurantid;
	}
}
