package com.fooddelivery.datasource;

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

}
