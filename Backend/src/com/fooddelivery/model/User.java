package com.fooddelivery.model;

public class User {
private String username;
private String password;
private int id;

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
