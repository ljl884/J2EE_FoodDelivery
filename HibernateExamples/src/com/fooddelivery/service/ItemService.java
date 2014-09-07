package com.fooddelivery.service;

import com.fooddelivery.datasource.ItemMapper;

public class ItemService {
	
	
	public void addItem(String name,String catagory,int price,String description){
		ItemMapper.insert(name, catagory, price, description);
	}
	
	public void updateItemPrice(int id,int price){
		ItemMapper.updatePrice(id, price);
	}
	
	public void deleteItem(int id){
		
		ItemMapper.deleteItem(id);
	}
}
