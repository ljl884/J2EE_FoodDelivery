package com.fooddelivery.service;

import java.util.List;

import com.fooddelivery.datasource.RestaurantMapper;
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
		
	}
	public void createRestaurant(){
		
	}
	public void deleteRestaurant(){
		
	}
}
