package com.fooddelivery.model;

public class User {
private String username;
private String password;
private Long id;

public Long getId() {
return id;
}

public void setId(Long id) {
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
