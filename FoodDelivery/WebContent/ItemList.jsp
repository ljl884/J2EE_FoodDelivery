<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
<p align="right"><% User user = (User)session.getAttribute("user");%>
<%if (user==null){%>
   <a href="index.html">Login Here</a>
 <%
	}
else 
	out.println("User:"+user.getUsername());%></p>
<h3>Searching Results</h3>
<p>Item_Id&nbsp;&nbsp;Item_Name&nbsp;&nbsp;Item_Category&nbsp;&nbsp;Item_Price&nbsp;&nbsp;Item_Description </p>
<%
ArrayList<Item> list=new ArrayList<Item>();
list = (ArrayList<Item>)request.getAttribute("result");	
for(Item item:list) {

out.println(item.getId());

out.println(item.getName());

out.println(item.getCatagory());

out.println(item.getPrice());
out.println(item.getDescription());
%><br>
<%
}
%>
<a href="AddItem.jsp">Click Here to Add Item</a>
</body>
</html>