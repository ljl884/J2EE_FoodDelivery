package com.fooddelivery.datasource;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.User;

public class ItemMapper extends DataMapper{
	public static int insert(String name,String catagory,int price,String description)
	{
		init();
		Item item = new Item();
		item.setName(name);
		item.setCatagory(catagory);
		item.setDescription(description);
		item.setPrice(price);

		session.save(item);
		int itemid=item.getId();
		close();
		return itemid;
	}
	public static int insert(Item item){
		init();
		int itemid=-1;
		if (item!=null) {
			session.save(item);
			item.getId();
		}
		close();
		return itemid;
	}
	public static void updatePrice(int id,int price){
		init();
		Item item = (Item)session.load(Item.class, id);
		item.setPrice(price);
		close();
	}
	
	public static void deleteItem(int id){
		init();
		Item item = (Item)session.load(Item.class, id);
		session.delete(item);
		close();
	}
	
	
}
