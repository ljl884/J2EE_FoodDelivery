package com.swen90007.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(request.getParameter("username"),request.getParameter("password"));
		//System.out.println(result);
		
		 if (result) {
			 User user = loginService.getUserDetails(request.getParameter("password"));
			 request.getSession().setAttribute("user", user);

		 response.sendRedirect("success.jsp");
		 return;
		 }
		 else {
		 response.sendRedirect("fail.jsp");
		 return;
		  }


		
		
	}

}