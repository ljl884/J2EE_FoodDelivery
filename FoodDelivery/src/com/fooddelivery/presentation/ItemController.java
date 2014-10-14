package com.fooddelivery.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.Item;
import com.fooddelivery.model.OrderItem;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.model.User;
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
		request.getSession().setAttribute("menu_id", new_id);
		ItemService is=new ItemService();
		String typeString = request.getParameter("type");
		if (typeString==null) {
			typeString="null";
		}
		if(typeString.equals("delete")){
	
			is.deleteItem(new_id);
			getServletConfig().getServletContext().getRequestDispatcher("/DeleteItemSuccess.jsp").forward(request,response);

		}
		else{
		List<Item> result=is.getItemByMenuId(new_id);
		request.setAttribute("result", result); 
		request.setAttribute("restaurantID", new_id);
		getServletConfig().getServletContext().getRequestDispatcher("/ItemList.jsp").forward(request,response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String deleteidString = request.getParameter("delete_id");
		String method=request.getParameter("method");
		if(method==null){
			method="normal";
		}
		if (method==deleteidString) {
			deleteidString="null";
		}
		
		ItemService is=new ItemService();
		if(method.equals("buy")){
			String res_id =(String) request.getParameter("restaurantid");			
			String user_id = (String) request.getParameter("userid");
			
			int userId=Integer.parseInt(user_id);
			User user=(User)request.getSession().getAttribute("user");
			String User=user.getUsername();
			
			int new_id=Integer.parseInt(res_id);
			
			ItemService itemService=new ItemService();
			List<Item> itemlist=itemService.getItemByMenuId(Integer.parseInt(res_id));
			ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
			
			for(Item item : itemlist){
				OrderItem orderItem = new OrderItem();
				orderItem.setItemid(item.getId());
				String value=request.getParameter(""+item.getId());
				if (value==null || value.equals("0")) {
					continue;
				}
				orderItem.setCount(Integer.parseInt(value));
				orderItems.add(orderItem);
			}
			request.setAttribute("orderItems", orderItems); 
			getServletConfig().getServletContext().getRequestDispatcher("/GenerateOrder.jsp").forward(request,response);
	
			
		}
		else if(method.equals("mod")){
			int mod_id=((Integer)request.getSession().getAttribute("mod_id")).intValue();

			String price=request.getParameter("price");
			int new_price=Integer.parseInt(price);
			String stock=request.getParameter("stock");
			is.updateItemPrice(mod_id, new_price);
			is.updateStock(mod_id, Integer.parseInt(stock));
			getServletConfig().getServletContext().getRequestDispatcher("/ModifyItemSuccess.jsp").forward(request,response);
		}
		else{
		String name=request.getParameter("name");
		String catagory=request.getParameter("category");
		String price=request.getParameter("price");
		int new_price=Integer.parseInt(price);
		String description=request.getParameter("description");
		String stock=request.getParameter("stock");
		int menu_id=((Integer)request.getSession().getAttribute("menu_id")).intValue();
		is.addItem(menu_id, name, catagory, new_price, description,Integer.parseInt(stock));

		getServletConfig().getServletContext().getRequestDispatcher("/AddItemSuccess.jsp").forward(request,response);}
	}

}
