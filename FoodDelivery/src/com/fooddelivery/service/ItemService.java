package com.fooddelivery.service;

import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.datasource.MenuItemMapper;
import com.fooddelivery.model.Item;

public class ItemService {
	
	
	public void addItem(int menuid,String name,String catagory,int price,String description){
		int itemid=ItemMapper.insert( name, catagory, price, description,menuid);
		MenuItemMapper.insert(menuid, itemid);
	}
	
	public void updateItemPrice(int id,int price){
		ItemMapper.updatePrice(id, price);
	}
	
	public void deleteItem(int id){
		
		ItemMapper.deleteItem(id);
	}
	public List<Item> getItemByMenuId(int menuid){
		return ItemMapper.getItemByMenuId(menuid);
		
	}
	public Item getItemById(int itemid){
		return ItemMapper.getItem(id);
	}
	
	
}
