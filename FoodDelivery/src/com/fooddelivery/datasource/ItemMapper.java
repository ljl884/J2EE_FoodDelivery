package com.fooddelivery.datasource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.User;

public class ItemMapper extends DataMapper{
	public static int insert(String name,String catagory,int price,String description,int menuid)
	{
		init();
		Item item = new Item();
		item.setName(name);
		item.setCatagory(catagory);
		item.setDescription(description);
		item.setPrice(price);
		item.setMenuid(menuid);

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
	
	public static Item getItem(int id){
		init();
		Item item = (Item)session.get(Item.class, id);
		close();
		return item;
	}
	
	public static List<Item> getItemByMenuId(int menuid){
		init();
		String hqlString="from Item where menuid='"+menuid+"'";
		Query query=session.createQuery(hqlString);
		List l = query.list();
		ArrayList<Item> list = new ArrayList<Item>();
		for(int i=0;i<l.size();i++)
		{
			Item item= (Item) l.get(i);
			list.add(item);			
		}
		close();
		return list;
	}
	
	public static void update(Item item){
		init();
		session.update(item);
		close();
	}
	public static int insert(String name, String catagory, int price,
			String description, int menuid, int stock) {
		init();
		Item item = new Item();
		item.setName(name);
		item.setCatagory(catagory);
		item.setDescription(description);
		item.setPrice(price);
		item.setMenuid(menuid);
		item.setStock(stock);

		session.save(item);
		int itemid=item.getId();
		close();
		return itemid;
	}
		
}
