package com.fooddelivery.datasource;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fooddelivery.model.User;

public class DataMapper {
	
	static SessionFactory sessionFactory;
	static Session session ;
	static Transaction tx ;
	
	protected static void init()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	}
	
	protected static void close()
	{
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	
	
}
