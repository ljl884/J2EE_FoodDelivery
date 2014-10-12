package com.fooddelivery.datasource;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

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
	public static CustomerInfo getCustomerInfoByOrderId(int id){
		init();
		String hqlString="from CustomerInfo where orderid='"+id+"'";
		Query query=session.createQuery(hqlString);
		if (query.list().size()==0) {
			return null;
		}
		else{
			CustomerInfo customerInfo = (CustomerInfo)query.list().get(0);
		
			return customerInfo;
		}
		
		
	}
}
