package com.fooddelivery.datasource;

import com.fooddelivery.model.CustomerInfo;

public class CustomerInfoMapper extends DataMapper{
	public static int insert(CustomerInfo customerInfo){
		int id=-1;
		init();
		if (customerInfo!=null) {
			session.save(customerInfo);
			id=customerInfo.getId();
		}
		close();
		return id;
	}
	public static CustomerInfo getCustomerInfo(int id){
		init();
		CustomerInfo customerInfo = (CustomerInfo)session.load(CustomerInfo.class, id);
		close();
		return customerInfo;
	}
}
