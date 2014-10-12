package com.fooddelivery.datasource;



import java.util.ArrayList;
import java.util.List;

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
	
	public static List<Order> getOrdersByRestaurantId(int restaurantId){
		init();
		String hqlString="from Order where restaurantid='"+restaurantId+"'";
		Query query=session.createQuery(hqlString);
		List l = query.list();
		ArrayList<Order> list = new ArrayList<Order>();
		for(int i=0;i<l.size();i++)
		{
			Order order= (Order) l.get(i);
			list.add(order);
			
		}
		close();
		return list;
		
	}
	public static List<Order> getOrdersByUserId(int userid){
		init();
		String hqlString="from Order where userid='"+userid+"'";
		Query query=session.createQuery(hqlString);
		List l = query.list();
		ArrayList<Order> list = new ArrayList<Order>();
		for(int i=0;i<l.size();i++)
		{
			Order order= (Order) l.get(i);
			list.add(order);
			
		}
		close();
		return list;
		
	}

	public static void update(Order order) {
		init();
		session.update(order);
		close();
		
	}
}
