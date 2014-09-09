package com.fooddelivery.presentation;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.ForceDiscriminator;

import com.fooddelivery.model.Restaurant;
import com.fooddelivery.model.User;
import com.fooddelivery.service.ItemService;
import com.fooddelivery.service.UserService;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		
		User result = userService.authenticate(request.getParameter("username"),request.getParameter("password"));
		
		
		//System.out.println(result);
		
		 if (result!=null) {
			 //User user = user.getUserDetails(request.getParameter("password"));
			 request.getSession().setAttribute("user", result);

		 response.sendRedirect("success.jsp");
		 return;
		 }
		 else {
		 response.sendRedirect("fail.jsp");
		 return;
		  }


		
		
	}

}