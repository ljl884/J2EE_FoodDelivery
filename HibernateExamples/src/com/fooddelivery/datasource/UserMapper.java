package com.fooddelivery.datasource;

import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.model.User;

public class UserMapper extends DataMapper{
	
	public static void all()
	{
		init();
		Query q = session.createQuery("select c.id,c.username,c.password from user as c");		
		List l = q.list();
		for(int i=0;i<l.size();i++)
		{
			//TestDb user = (TestDb)l.get(i);
			//System.out.println(user.getUsername());

			  Object[] row = (Object[])l.get(i);;
			  Long id = (Long)row[0];
			  String name = (String)row[1];  
			  System.out.println(id+" "+name);
		}
		close();
	}
	
	
	public static User load()
	{
		init();
		User obj = (User) session.load(User.class, new Long(2));
		
		close();
		return obj;
	}
	
	
	public static void update(User user)
	{
		init();
		User obj = (User) session.load(User.class, new Long(2));
		obj.setUsername("cg");
		close();
	}
	
	
	public static void insert(String username,String password)
	{
		init();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		session.save(user);
		close();
	}
}
