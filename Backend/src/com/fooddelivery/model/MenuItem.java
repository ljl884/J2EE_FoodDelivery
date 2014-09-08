package com.fooddelivery.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItem {
	private int id;
	private int menuid;
	private int itemid;
	
	@Id
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getMenuid(){
		return menuid;
	}
	
	public void setMenuid(int menuid){
		this.menuid=menuid;
	}
	
	public int getItemid(){
		return itemid;
	}
	
	public void setItemid(int itemid){
		this.itemid = itemid;
	}
	
	
	
}
