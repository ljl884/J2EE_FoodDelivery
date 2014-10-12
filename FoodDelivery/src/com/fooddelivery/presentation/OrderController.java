package com.fooddelivery.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.CustomerInfo;
import com.fooddelivery.model.DeliverAddress;
import com.fooddelivery.model.Item;
import com.fooddelivery.model.Order;
import com.fooddelivery.model.OrderItem;
import com.fooddelivery.model.PaymentMethod;
import com.fooddelivery.model.PendingOrder;
import com.fooddelivery.service.ItemService;
import com.fooddelivery.service.OrderService;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search_id=request.getParameter("id");
		String typeString = request.getParameter("type");
		OrderService os=new OrderService();
		if (typeString==null) {
			typeString="null";
		}
		if(typeString.equals("delete")){
	
			os.deleteOrder(Integer.parseInt(search_id));
			getServletConfig().getServletContext().getRequestDispatcher("/DeleteOrderSuccess.jsp").forward(request,response);

		}
		else{
//			List<Item> result=is.getItemByMenuId(new_id);
//			request.setAttribute("result", result); 
//			request.setAttribute("restaurantID", new_id);
//			getServletConfig().getServletContext().getRequestDispatcher("/ItemList.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customer_Info=request.getParameter("receiver_name");
		String payment=request.getParameter("payment");
		String delivery_Address=request.getParameter("delivery_address");

		String res_id =(String) request.getSession().getAttribute("res_id");
		String user_id =(String) request.getSession().getAttribute("user_id");
		//int userId=Integer.parseInt(user_id);
		Order order1  = new Order();
		order1.setRestaurantid(Integer.parseInt(res_id));
		order1.setUserid(Integer.parseInt(user_id));
		ArrayList<OrderItem> list=new ArrayList<OrderItem>();
		ItemService is=new ItemService();
		if(request.getSession().getAttribute("OrderItem")!=null){
			list = (ArrayList<OrderItem>)request.getSession().getAttribute("OrderItem");
		}
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		OrderItem item = new OrderItem();
		
		for(OrderItem orderitem:list) {
			item.setItemid(orderitem.getItemid());
			item.setCount(orderitem.getCount());
			orderItems.add(item);
		}
		
		
//      out.println(orderitem.getId());
//		System.err.println(orderitem.getItemid());
		
//		System.err.println(is.getItemById(orderitem.getItemid()).getName());
		
//		System.err.println(orderitem.getCount());		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName(customer_Info);
		
		DeliverAddress deliverAddress = new DeliverAddress();
		deliverAddress.setAddress(delivery_Address);
		
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setName(payment);

		PendingOrder pendingOrder=new PendingOrder(order1, orderItems, customerInfo, deliverAddress, paymentMethod);
		OrderService orderService=new OrderService();
		orderService.createOrder(pendingOrder);
		response.sendRedirect("ViewOrder.jsp");
//		System.out.println(customer_Info);
//		System.out.println(payment);
//		System.out.println(delivery_Address);
	}

}
