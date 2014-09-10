package com.fooddelivery.service;

import java.util.List;

import com.fooddelivery.datasource.ItemMapper;
import com.fooddelivery.datasource.MenuMapper;
import com.fooddelivery.datasource.RestaurantMapper;
import com.fooddelivery.model.Item;
import com.fooddelivery.model.Menu;
import com.fooddelivery.model.Restaurant;

public class RestaurantService {
	public List<Restaurant> getRestaurantsByName(String name){
		return RestaurantMapper.getRestaurantByName(name);
	}
	public List<Restaurant> getRestaurantsByPrice(String price){
		return RestaurantMapper.getRestaurantByPrice(price);
	}
	public List<Restaurant> getRestaurantsByCategory(String category){
		return RestaurantMapper.getRestaurantByCategory(category);
	}
	public List<Restaurant> getRestaurantsByLocation(String location){
		return RestaurantMapper.getRestaurantByLocation(location);
	}
	
	public List<Menu> getMenuFromRestaurant(int restaurantid){
		return MenuMapper.getMenuFromRestaurant(restaurantid);
	}
	
	public Menu getFirstMenuFromRestaurant(int restaurantid){
		
		return MenuMapper.getFirstMenu(restaurantid);
		
	}
	
	public List<Item> getFirstMenuItemsFromRestaurant(int restaurantid){
		Menu menu = getFirstMenuFromRestaurant(restaurantid);
		return  ItemMapper.getItemByMenuId(menu.getId());
	}
	
	public static Restaurant getRestaurantByItemId(int itemid){
		
		return null;
	}
	
	
	public void createRestaurant(){
		
	}
	public void deleteRestaurant(int restaurantid){
		
	}
}
