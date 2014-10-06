package com.fooddelivery.service;

import java.util.ArrayList;
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
		ArrayList<Item> resultItems =new ArrayList<Item>();
		Menu menu = getFirstMenuFromRestaurant(restaurantid);
		
		resultItems =  (ArrayList<Item>) ItemMapper.getItemByMenuId(menu.getId());
		return resultItems;
	}
	
	public int getRestaurantIdByItemId(int itemid){
		return MenuMapper.getMenu(ItemMapper.getItem(itemid).getMenuid()).getRestaurantid();
		
	}
	public int getRestaurantIdByMenuId(int menuid){
		return MenuMapper.getMenu(menuid).getRestaurantid();
		
	}
	
	
	public void createRestaurant(){
		
	}
	public void deleteRestaurant(int restaurantid){
		
	}
}
