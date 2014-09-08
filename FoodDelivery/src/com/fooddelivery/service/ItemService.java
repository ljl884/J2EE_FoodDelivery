package com.fooddelivery.service;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.datasource.MenuItemMapper;

public class ItemService {
	
	
	public void addItem(int menuid,String name,String catagory,int price,String description){
		int itemid=ItemMapper.insert(name, catagory, price, description);
		MenuItemMapper.insert(menuid, itemid);
	}
	
	public void updateItemPrice(int id,int price){
		ItemMapper.updatePrice(id, price);
	}
	
	public void deleteItem(int id){
		
		ItemMapper.deleteItem(id);
	}
}
