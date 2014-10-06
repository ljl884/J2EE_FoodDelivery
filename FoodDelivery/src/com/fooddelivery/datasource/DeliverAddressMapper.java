package com.fooddelivery.datasource;

import com.fooddelivery.model.DeliverAddress;

public class DeliverAddressMapper extends DataMapper{
	public static int insert(DeliverAddress deliverAddress){
		int id = -1;
		init();
		if (deliverAddress!=null) {
			session.save(deliverAddress);
			id=deliverAddress.getId();
		}
		close();
		return id;
		
	}
	
	public static DeliverAddress getDeliverAddress(int id){
		init();
		DeliverAddress deliverAddress = (DeliverAddress)session.load(DeliverAddress.class, id);
		close();
		return deliverAddress;
	}
}
