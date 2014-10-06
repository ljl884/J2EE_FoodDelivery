package com.fooddelivery.datasource;



import com.fooddelivery.model.Order;
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
		Order order = (Order)session.load(Order.class, id);
		close();
		return order;
	}
}
