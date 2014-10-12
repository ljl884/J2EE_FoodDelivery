package com.fooddelivery.service;

import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.datasource.MenuItemMapper;
import com.fooddelivery.datasource.MenuMapper;
import com.fooddelivery.datasource.RestaurantMapper;
import com.fooddelivery.model.Item;

public class ItemService {
	
	
	public void addItem(int menuid,String name,String catagory,int price,String description){
		int itemid=ItemMapper.insert( name, catagory, price, description,menuid);
		MenuItemMapper.insert(menuid, itemid);
	}
	public void addItem(int menuid,String name,String catagory,int price,String description,int stock){
		int itemid=ItemMapper.insert( name, catagory, price, description,menuid,stock);
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
		return ItemMapper.getItem(itemid);
	}
	
	public boolean dropItemStock(int itemid, int amount){
		Item item = ItemMapper.getItem(itemid);
		if (item==null) {
			return false;
		}
		else {
			if (item.getStock()<amount) {
				return false;
			}
			else {
				item.setStock(item.getStock()-amount);
				return true;
			}
		}
		
	}
	
	public void addItemStock(int itemid,int amount){
		Item item = ItemMapper.getItem(itemid);
		if(item==null){
			return;
		}
		else {
			item.setStock(item.getStock()+amount);
		}
	}
	
	public void updateStock(int itemid,int amount){
		Item item = ItemMapper.getItem(itemid);
		if (item==null || amount<0) {
			return;	
		}
		else {
			item.setStock(amount);
			ItemMapper.update(item);
		}
	}
	
	
}
