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

public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search_id=request.getParameter("id");
		int new_id=Integer.parseInt(search_id);
		ItemService is=new ItemService();
		List<Item> result=is.getItemByMenuId(new_id);
		request.setAttribute("result", result); 
		getServletConfig().getServletContext().getRequestDispatcher("/ItemList.jsp").forward(request,response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search_id=request.getParameter("id");
		int new_id=Integer.parseInt(search_id);
		ItemService is=new ItemService();
		RestaurantService rs = new RestaurantService();
		
		List<Item> result=is.getItemByMenuId(rs.getFirstMenuFromRestaurant(new_id).getId());
		request.setAttribute("result", result); 
		getServletConfig().getServletContext().getRequestDispatcher("/ItemList.jsp").forward(request,response);;
	}

}
