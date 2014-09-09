package com.fooddelivery.service;

import javax.jws.soap.SOAPBinding.Use;

import com.fooddelivery.datasource.UserMapper;
import com.fooddelivery.model.User;

public class UserService {
	
	
	public boolean addUser(String username, String password){
		UserMapper.insert(username, password);
		return true;
	}
	public void getUserList(){
		UserMapper.all();
	}
	
	public User authenticate(String username, String password){		
		
		User user=UserMapper.load(username);
		if (user==null) {
			return null;
		}
		else if(!(user.getPassword().equals(password)))
			return null;
		else
		return user;
		 
		
	}
}
