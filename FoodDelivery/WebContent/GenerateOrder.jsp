<%@page import="com.fooddelivery.service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Information</title>
</head>
<body>
<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
<%
ArrayList<OrderItem> list=new ArrayList<OrderItem>();
ItemService is=new ItemService();
if(request.getAttribute("orderItems")!=null){
	list = (ArrayList<OrderItem>)request.getAttribute("orderItems");
}
session.setAttribute("OrderItem",list);
for(OrderItem orderitem:list) {
	//out.println(orderitem.getId());
	out.println(orderitem.getItemid());
	
	out.println(is.getItemById(orderitem.getItemid()).getName());
	
	out.println(orderitem.getCount());
	%>
	<br>
	<%
}
 %>
<form action=OrderController method="post">
Receiver name <input type="text" name=receiver_name><br>
Payment Method<br>
<input type="radio" name="payment" value="cash" /> Cash
<br>
<input type="radio" name="payment" value="card" /> Card
<br>
Delivery Address <input type="text" name=delivery_address><br>
<input type="submit" value="Submit Order">
</form>

</body>
</html>