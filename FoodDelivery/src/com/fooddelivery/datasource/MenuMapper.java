package com.fooddelivery.datasource;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.Menu;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.model.User;

public class MenuMapper extends DataMapper{
	
	public static Menu getMenu(int id){
		
		init();
		Menu menu = (Menu)session.load(Menu.class, id);
		close();
		return menu;
	}
	
	public static Menu getFirstMenu(int restaurantid){
		
		init();
		String hqlString="from Menu where restaurantid='"+restaurantid+"'";
		Query query=session.createQuery(hqlString);
		if (query.list().size()==0) {
			return null;
		}
		else{
		Menu menu= (Menu) query.list().get(0);
		close();
		return menu;}
	}
	
	public static List<Menu> getMenuFromRestaurant(int restaurantid){
		init();
		
		String hqlString="from Menu where restaurantid='"+restaurantid+"'";
		Query query=session.createQuery(hqlString);
		ArrayList<Menu> list=new ArrayList<Menu>();
		List l = query.list();
		if (l.size()==0) {
			close();
			return null;
		}
		else{
			for(int i=0;i<l.size();i++)
			{
				Menu menu= (Menu) l.get(i);
				list.add(menu);
				
			}
		close();
		return list;}
	}

	
}
