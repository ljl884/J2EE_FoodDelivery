package com.fooddelivery.datasource;

import java.util.List;

import org.hibernate.Query;

import com.fooddelivery.model.User;

public class UserMapper extends DataMapper{
	
	public static void all()
	{
		init();
		Query q = session.createQuery("from User");		
		List l = q.list();
		for(int i=0;i<l.size();i++)
		{
			User user = (User) l.get(i);
		}
		close();
	}
	
	
	public static User load(String username)
	{
		init();
		//User obj = (User) session.load(User.class, new Long(2));
		//session.createQuery(arg0)
		String hqlString="from User where username='"+username+"'";
		Query query=session.createQuery(hqlString);
		if (query.list().size()==0) {
			return null;
		}
		else{
		User user = (User) query.list().get(0);
		close();
		return user;}
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
