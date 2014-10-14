package com.fooddelivery.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.service.ItemService;
import com.fooddelivery.service.RestaurantService;

/**
 * Servlet implementation class ItemController
 */

public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**Get the parameter "id", and parse to integer.
     * handle the delete Item, and redirect to DeleteItemSuccess.jsp
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search_id=request.getParameter("id");
		int new_id=Integer.parseInt(search_id);
		ItemService is = new ItemService();
		is.deleteItem(new_id);
		getServletConfig().getServletContext().getRequestDispatcher("/DeleteItemSuccess.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int menuid,String name,String catagory,int price,String description
	}

}
