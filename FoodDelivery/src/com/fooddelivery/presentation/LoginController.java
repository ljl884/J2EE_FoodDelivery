package com.fooddelivery.presentation;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.service.*;
import com.fooddelivery.model.*;


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

/**receive user name and password, and save to session. 
 * Finally, if user name and password are correct, then redirect to success.jsp;other wise redirect to fail.jsp.
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		User result = userService.authenticate(request.getParameter("username"),request.getParameter("password"));
         
		 if (result!=null) {
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