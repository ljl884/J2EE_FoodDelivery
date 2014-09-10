package com.fooddelivery.model;

public class User {
private String username;
private String password;
private int id;
private int restaurantid;

public int getRestaurantid() {
	return restaurantid;
}

public void setRestaurantid(int restaurantid) {
	this.restaurantid = restaurantid;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getUsername() {
return username;
}

public void setUsername(String myname) {
this.username = myname;
}

public void setPassword(String password){
	this.password=password;
}

public String getPassword(){
	return password;
}


}
