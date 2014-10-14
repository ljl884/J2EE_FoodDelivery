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

OrderService orderService=new OrderService();
if(isOwner){
	List<PendingOrder> list=orderService.getOrdersByRestaurantId(user_restaurant);
	for(PendingOrder pendingorder:list){%>
	
	<%
	
    
    out.println("ORDER"+pendingorder.getId()+":");
    %><br>
    
    <%
		
	    
		out.println("&nbsp&nbsp&nbsp&nbsp&nbsp"+"User ID:"+pendingorder.getOrder().getUserid()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
		out.println("Status:"+pendingorder.getOrder().getStatus());
		%><br>
        <%out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"Customer Name:"+pendingorder.getCustomerInfo().getName()+"&nbsp&nbsp&nbsp&nbsp");
        out.println("Delivery Address:"+pendingorder.getDeliverAddress().getAddress()+"&nbsp&nbsp&nbsp&nbsp");
        out.println("Payment Method:"+pendingorder.getPaymentMethod().getName()+"&nbsp&nbsp&nbsp&nbsp");%><br>
	    <%
		
		
		
		List<OrderItem> Itemlist=pendingorder.getOrderItems();
		for(OrderItem orderitem:Itemlist){
            out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"Item ID:"+orderitem.getItemid()+"&nbsp&nbsp&nbsp&nbsp");
            out.println("Count:"+orderitem.getCount()+"&nbsp&nbsp&nbsp&nbsp");%><br><%
		}%><br><%
		if (!orderService.isOrderConfirmed(pendingorder.getId())){ %>
	    <b> <a href="OrderController?type=confirm&id=<%=pendingorder.getId()%>">Confirm</a></b><br>

		<% }%>
	   <hr><%	
	  }
	}
else{
	List<PendingOrder> list=orderService.getOrdersByUserId(user.getId());
	for(PendingOrder pendingorder:list){
    out.println("ORDER"+pendingorder.getId()+":");
    %><br>

    <%
		
	    
		out.println("&nbsp&nbsp&nbsp&nbsp&nbsp"+"Restaurant ID:"+pendingorder.getOrder().getRestaurantid()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
		out.println("Status:"+pendingorder.getOrder().getStatus());
		%><br>
        <%
		out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"Customer Name:"+pendingorder.getCustomerInfo().getName()+"&nbsp&nbsp&nbsp&nbsp");
		out.println("Delivery Address:"+pendingorder.getDeliverAddress().getAddress()+"&nbsp&nbsp&nbsp&nbsp");
		out.println("Payment Method:"+pendingorder.getPaymentMethod().getName()+"&nbsp&nbsp&nbsp&nbsp");
		%><br>
		<%
		
		
		
		List<OrderItem> Itemlist=pendingorder.getOrderItems();
		for(OrderItem orderitem:Itemlist){
			out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"Item ID:"+orderitem.getItemid()+"&nbsp&nbsp&nbsp&nbsp");
			out.println("Count:"+orderitem.getCount()+"&nbsp&nbsp&nbsp&nbsp");%><br><%
		}%><br>
		<%
		if (!orderService.isOrderConfirmed(pendingorder.getId())){ %>
		<b><a  href="OrderController?type=delete&id=<%=pendingorder.getId()%>">Delete</a></b><br>
		<%}%><hr><%
	}
	}

%>
</body>
</html>