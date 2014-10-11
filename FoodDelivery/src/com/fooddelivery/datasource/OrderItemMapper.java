package com.fooddelivery.datasource;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.model.Item;
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
	
	public static void insert(ArrayList<OrderItem> list){
		init();
		for(OrderItem item:list){
			session.save(item);
		}
		close();
	}
	
	public static OrderItem getOrderItem(int id){
		init();
		OrderItem result = (OrderItem) session.load(OrderItem.class, id);
		close();
		return result;
	}
	
	public static List<OrderItem> getOrderItemsByOrderId(int id){
		init();
		String hqlString="from OrderItem where orderid='"+id+"'";
		Query query=session.createQuery(hqlString);
		List l = query.list();
		ArrayList<OrderItem> list = new ArrayList<OrderItem>();
		for(int i=0;i<l.size();i++)
		{
			OrderItem item= (OrderItem) l.get(i);
			list.add(item);
			System.out.println("order item:"+item.getId()+" itemid: "+item.getItemid());
			
		}
		close();
		return list;
	}
}
