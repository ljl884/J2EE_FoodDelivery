package com.fooddelivery.service;

import com.fooddelivery.datasource.UserMapper;

public class UserService {
	
	
	public boolean addUser(String username, String password){
		UserMapper.insert(username, password);
		return true;
	}
	public void getUserList(){
		
	}
}
