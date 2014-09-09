package com.fooddelivery.datasource;

import com.fooddelivery.model.Menu;

public class MenuMapper extends DataMapper{
	
	public static Menu getMenu(int id){
		init();
		Menu menu = (Menu)session.load(Menu.class, id);
		close();
		return menu;
	}
}
