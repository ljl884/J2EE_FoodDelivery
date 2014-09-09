package com.fooddelivery.main;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.service.ItemService;
import com.fooddelivery.service.UserService;

public class main {
	public static void main(String[] args){
		
		UserService userService=new UserService();
		ItemService itemService=new ItemService();
		
		//itemService.addItem(1,"°¢Ë¹¶Ù", "·Å´ó", 50, "¹þ¹þ¹þ¹þ");
		//itemService.updateItemPrice(1, 20);
		//itemService.deleteItem(1);
		//userService.getUserList();
		itemService.getItemByMenuId(1);
	}
	
}
