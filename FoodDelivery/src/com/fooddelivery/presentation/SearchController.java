package com.fooddelivery.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.service.RestaurantService;
/**
 * Servlet implementation class Trans
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		
		String keywords=request.getParameter("keywords");
		String type_name=request.getParameter("search_name");
		String type_category=request.getParameter("search_category");
		String type_location=request.getParameter("search_location");
		String type_price=request.getParameter("search_price");
		//System.out.println(type_name+"    "+type_category+"      "+type_location+"     "+type_price);
		RestaurantService rs=new RestaurantService();
		
		if(type_price!=null){
			if(type_price.equals("search by price")){
			   //int new_keywords=Integer.parseInt(keywords);
				List<Restaurant> result=rs.getRestaurantsByPrice(keywords);
				request.setAttribute("pri_result", result); 
				getServletConfig().getServletContext().getRequestDispatcher("/RestaurantList.jsp").forward(request,response);
			}
			}
		else if(type_category!=null){
		    if(type_category.equals("search by category")){
			
		    List<Restaurant> result=rs.getRestaurantsByCategory(keywords);
			request.setAttribute("cat_result", result); 
			getServletConfig().getServletContext().getRequestDispatcher("/RestaurantList.jsp").forward(request,response);
		}
		}
		else if(type_location!=null){
		if(type_location.equals("search by location")){
			 List<Restaurant> result=rs.getRestaurantsByLocation(keywords);
				request.setAttribute("loc_result", result); 
				getServletConfig().getServletContext().getRequestDispatcher("/RestaurantList.jsp").forward(request,response);
		}
		}
		else if(type_name!=null){
		if(type_name.equals("search by name")){
			List<Restaurant> result=rs.getRestaurantsByName(keywords);
			request.setAttribute("nam_result", result); 
			getServletConfig().getServletContext().getRequestDispatcher("/RestaurantList.jsp").forward(request,response);

		}
		}
		
	}

}
