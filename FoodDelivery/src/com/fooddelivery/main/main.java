package com.fooddelivery.main;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.datasource.OrderMapper;
import com.fooddelivery.model.CustomerInfo;
import com.fooddelivery.model.Item;
import com.fooddelivery.model.Menu;
import com.fooddelivery.model.Order;
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
	
		PendingOrder order = orderService.getOrder(1);
		System.out.println(order.getId());
		System.out.println(order.getRestaurantid());
		System.out.println(order.getCustomerInfo().getName());
		System.out.println(order.getDeliverAddress().getAddress());
		System.out.println(order.getPaymentMethod().getMethod());
		
		orderService.createOrder(order);
//		
		
		
	}
	
}
