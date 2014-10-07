package com.fooddelivery.datasource;

import org.hibernate.Query;

import com.fooddelivery.model.DeliverAddress;
import com.fooddelivery.model.PaymentMethod;

public class PaymentMethodMapper extends DataMapper{
	
	public static int insert(PaymentMethod paymentMethod){
		int id = -1;
		init();
		if (paymentMethod!=null) {
			session.save(paymentMethod);
			id = paymentMethod.getId();
		}
		return id;
	}
	
	public static PaymentMethod getPaymentMethod(int id){
		init();
		PaymentMethod paymentMethod = (PaymentMethod)session.get(PaymentMethod.class, id);
		close();
		return paymentMethod;
	}
	
	public static PaymentMethod getPaymentMethodByOrderId(int id){
		init();
		String hqlString="from PaymentMethod where orderid='"+id+"'";
		Query query=session.createQuery(hqlString);
		if (query.list().size()==0) {
			return null;
		}
		else{
			PaymentMethod paymentMethod = (PaymentMethod)query.list().get(0);
			System.out.println(paymentMethod.getMethod());
			return paymentMethod;
		}
	}

}
