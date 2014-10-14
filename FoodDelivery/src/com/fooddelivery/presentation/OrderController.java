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
    /**
     * Handle the modify and delete order function.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//receive the id and command.
		String search_id=request.getParameter("id");
		String typeString = request.getParameter("type");
		OrderService os=new OrderService();
		if (typeString==null) {
			typeString="null";
		}
		//if the command is delete, and do the action
		if(typeString.equals("delete")){
	
			os.deleteOrder(Integer.parseInt(search_id));
			getServletConfig().getServletContext().getRequestDispatcher("/DeleteOrderSuccess.jsp").forward(request,response);

		}
		//if the command is confirm, and do the action.
		else if(typeString.equals("confirm")){
			os.confirmOrder(Integer.parseInt(search_id));
			getServletConfig().getServletContext().getRequestDispatcher("/ViewOrder.jsp").forward(request,response);
		}
		else{
			getServletConfig().getServletContext().getRequestDispatcher("/ViewOrder.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * Receive customer's information and use them to create a pending order.
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //receive customer information, which is receiver name, payment method, and delivery address.
		String customer_Info=request.getParameter("receiver_name");
		String payment=request.getParameter("payment");
		String delivery_Address=request.getParameter("delivery_address");
     //receive restaurant id and user id from the session.
		String res_id =(String) request.getSession().getAttribute("res_id");
		String user_id =(String) request.getSession().getAttribute("user_id");
	 //create new order, and set restaurant id and user id.
		Order order1  = new Order();
		order1.setRestaurantid(Integer.parseInt(res_id));
		order1.setUserid(Integer.parseInt(user_id));
		ArrayList<OrderItem> list=new ArrayList<OrderItem>();
		if(request.getSession().getAttribute("OrderItem")!=null){
			list = (ArrayList<OrderItem>)request.getSession().getAttribute("OrderItem");
		}
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		
	//add item to orderItems
		for(OrderItem orderitem:list) {
			OrderItem item = new OrderItem();
			item.setItemid(orderitem.getItemid());
			item.setCount(orderitem.getCount());
			orderItems.add(item);
		}
	//set customer information, delivery address, and payment method to the pending order.			
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName(customer_Info);
		
		DeliverAddress deliverAddress = new DeliverAddress();
		deliverAddress.setAddress(delivery_Address);
		
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setName(payment);

		PendingOrder pendingOrder=new PendingOrder(order1, list, customerInfo, deliverAddress, paymentMethod);
		OrderService orderService=new OrderService();
		orderService.createOrder(pendingOrder);
	//finally, redirect to ViewOrder.jsp
		response.sendRedirect("ViewOrder.jsp");
	}

}
