package com.fooddelivery.datasource;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.Restaurant;

public class RestaurantMapper extends DataMapper {
	
	public static List<Restaurant> getRestaurant(String hql){
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		init();
		Query query=session.createQuery(hql);
		List l = query.list();
		for(int i=0;i<l.size();i++)
		{
			Restaurant restaurant= (Restaurant) l.get(i);
			list.add(restaurant);
			System.out.println(restaurant.getId()+" "+restaurant.getName());
			
		}
		close();
		return list;
	}
	
	public static List<Restaurant> getRestaurantByPrice(String price){
		return getRestaurant("from Restaurant where price='"+price+"'");
	}
	public static List<Restaurant> getRestaurantByLocation(String location){
		return getRestaurant("from Restaurant where location='"+location+"'");

	}
	public static List<Restaurant> getRestaurantByCategory(String category){
		return getRestaurant("from Restaurant where category='"+category+"'");

	}
	public static List<Restaurant> getRestaurantByName(String name){
		return getRestaurant("from Restaurant where name='"+name+"'");
	}
	
	
}
