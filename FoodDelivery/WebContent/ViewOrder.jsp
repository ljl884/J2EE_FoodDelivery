<%@page import="com.fooddelivery.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View My Order</title>
</head>
<body>
<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
<%@page import="com.fooddelivery.service.RestaurantService"%>
<%@page import="com.fooddelivery.datasource.MenuMapper"%>
<jsp:include page="header.jsp"/>
<% User user = (User)session.getAttribute("user");%>
<% boolean isOwner=false;
int user_restaurant = 0;
RestaurantService rs=new RestaurantService();

if (user==null){%>
   
 <%
	}
else {
	user_restaurant=user.getRestaurantid();
	if(user_restaurant!=0)
		isOwner=true;
	} %>
<% 
//String res_id =(String)request.getSession().getAttribute("res_id");
//String user_id =(String)request.getSession().getAttribute("user_id");
OrderService orderService=new OrderService();
if(isOwner){
	List<PendingOrder> list=orderService.getOrdersByRestaurantId(user_restaurant);
	for(PendingOrder pendingorder:list){%>
	
	<%
	
    
    out.println("ID"+pendingorder.getId()+":");
    %><br>
    
    <%
		
	    
		out.println("User ID:"+pendingorder.getOrder().getUserid());
		out.println("Status:"+pendingorder.getOrder().getStatus());
		out.println("Customer Name:"+pendingorder.getCustomerInfo().getName());
		out.println("Delivery Address:"+pendingorder.getDeliverAddress().getAddress());
		out.println("Payment Method:"+pendingorder.getPaymentMethod().getName());%><br>
	     <a href="OrderController?type=confirm&id=<%=pendingorder.getId()%>">confirm</a>
		&nbsp;&nbsp;
		<%
		
		List<OrderItem> Itemlist=pendingorder.getOrderItems();
		for(OrderItem orderitem:Itemlist){
			out.println("Item ID:"+orderitem.getItemid());
			out.println("Count:"+orderitem.getCount());
		}
	}
	}
else{
	List<PendingOrder> list=orderService.getOrdersByUserId(user.getId());
	for(PendingOrder pendingorder:list){
    out.println("ID"+pendingorder.getId()+":");
    %><br>

    <%
		
	    
		out.println("Restaurant ID:"+pendingorder.getOrder().getRestaurantid()+"   ");
		out.println("Status:"+pendingorder.getOrder().getStatus()+"   ");
		out.println("Customer Name:"+pendingorder.getCustomerInfo().getName()+"   ");
		out.println("Delivery Address:"+pendingorder.getDeliverAddress().getAddress()+"   ");
		out.println("Payment Method:"+pendingorder.getPaymentMethod().getName()+"   ");
		%><br>
		<%
		
		if (!orderService.isOrderConfirmed(pendingorder.getId())){ %>
		<a  href="OrderController?type=delete&id=<%=pendingorder.getId()%>">delete</a>
		&nbsp;&nbsp;
		<%}
		
		List<OrderItem> Itemlist=pendingorder.getOrderItems();
		for(OrderItem orderitem:Itemlist){
			out.println("Item ID:"+orderitem.getItemid());
			out.println("Count:"+orderitem.getCount());
		}
	}
	}

%>
</body>
</html>