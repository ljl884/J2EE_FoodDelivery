package com.fooddelivery.datasource;

import org.hibernate.Query;


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
	
	public static DeliverAddress getDeliverAddressByOrderId(int id){
		init();
		String hqlString="from DeliverAddress where orderid='"+id+"'";
		Query query=session.createQuery(hqlString);
		if (query.list().size()==0) {
			return null;
		}
		else{
			DeliverAddress deliverAddress = (DeliverAddress)query.list().get(0);
			System.out.println(deliverAddress.getAddress());
			return deliverAddress;
		}
		
	}
}
