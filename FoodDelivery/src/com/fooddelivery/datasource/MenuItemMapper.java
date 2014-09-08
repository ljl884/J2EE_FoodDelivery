package com.fooddelivery.datasource;

import com.fooddelivery.model.MenuItem;

public class MenuItemMapper extends DataMapper {

	public static void insert(int menuid,int itemid){
		init();
		MenuItem menuItem=new MenuItem();
		menuItem.setMenuid(menuid);
		menuItem.setItemid(itemid);
		session.save(menuItem);
		close();
	}
	
}
