package com.fooddelivery.main;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.service.ItemService;
import com.fooddelivery.service.UserService;

public class main {
	public static void main(String[] args){
		
		UserService userService=new UserService();
		ItemService itemService=new ItemService();
		
		itemService.addItem(1,"item2", "china", 110, "goooood");
		//itemService.updateItemPrice(1, 20);
		//itemService.deleteItem(1);
	}
	
}
