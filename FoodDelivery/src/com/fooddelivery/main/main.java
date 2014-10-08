package com.fooddelivery.main;

import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.datasource.OrderMapper;
import com.fooddelivery.model.CustomerInfo;
import com.fooddelivery.model.DeliverAddress;
import com.fooddelivery.model.Item;
import com.fooddelivery.model.Menu;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.OrderItem;
import com.fooddelivery.model.PaymentMethod;
import com.fooddelivery.model.PendingOrder;
import com.fooddelivery.service.ItemService;
import com.fooddelivery.service.OrderService;
import com.fooddelivery.service.RestaurantService;
import com.fooddelivery.service.UserService;

public class main {
	public static void main(String[] args){
		
		UserService userService=new UserService();
		ItemService itemService=new ItemService();
		RestaurantService restaurantService = new RestaurantService();
		OrderService orderService = new OrderService();
		
		//Menu menu=restaurantService.getFirstMenuFromRestaurant(1);
		//System.out.print("menuid:"+menu.getId());
		//restaurantService.getRestaurantsByPrice(30);
		//userService.authenticate("a", "1").getRestaurantid();
		//restaurantService.getFirstMenuItemsFromRestaurant(1);
		//itemService.addItem(1,"°¢Ë¹¶Ù", "·Å´ó", 50, "¹þ¹þ¹þ¹þ");
		//itemService.updateItemPrice(1, 20);
		//itemService.deleteItem(1);
		//userService.getUserList();
	

		
//		Order order1  = new Order();
//		order1.setRestaurantid(3);
//		order1.setUserid(3);
//		
//		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
//		OrderItem item = new OrderItem();
//		item.setItemid(3);
//		item.setCount(3);
//		orderItems.add(item);
//		
//		CustomerInfo customerInfo = new CustomerInfo();
//		customerInfo.setName("test customer");
//		
//		DeliverAddress deliverAddress = new DeliverAddress();
//		deliverAddress.setAddress("some where");
//		
//		PaymentMethod paymentMethod = new PaymentMethod();
//		paymentMethod.setName("test pay");
//	
//		
//		
//		PendingOrder order =new PendingOrder(order1, orderItems, customerInfo, deliverAddress, paymentMethod);
//		
//		int id= orderService.createOrder(order);
//		
//		PendingOrder order2 = orderService.getOrder(id);
//		System.out.println(order2.getId());
//		System.out.println(order2.getRestaurantid());
//		System.out.println(order2.getCustomerInfo().getName());
//		System.out.println(order2.getDeliverAddress().getAddress());
//		System.out.println(order2.getPaymentMethod().getName());
		
		List<PendingOrder> d =orderService.getOrdersByRestaurantId(3);
		
		for(PendingOrder o:d){
			System.err.println("id:"+o.getId());
			System.err.println("restid:"+o.getRestaurantid());
			System.err.println("pay:"+o.getPaymentMethod().getName());
			System.err.println("add:"+o.getDeliverAddress().getAddress());
			
		}
		
	}
	
}
