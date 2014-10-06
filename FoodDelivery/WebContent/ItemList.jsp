<%@page import="com.fooddelivery.datasource.MenuMapper"%>
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
<jsp:include page="header.jsp"/>
<% User user = (User)session.getAttribute("user");%>
<%
boolean isOwner=false;
int user_restaurant = 0;

if (user==null){%>
   
 <%
	}
else {
	user_restaurant=user.getRestaurantid();
	if(user_restaurant==1)
		isOwner=true;
	} %>
<h3>Searching Results</h3>
<p>Id&nbsp;&nbsp;Name&nbsp;&nbsp;Category&nbsp;&nbsp;Price&nbsp;&nbsp;Description </p>
<%
ArrayList<Item> list=new ArrayList<Item>();
list = (ArrayList<Item>)request.getAttribute("result");	

//System.out.print(menu.getRestaurantid());
for(Item item:list) {
	
out.println(item.getId());

out.println(item.getName());

out.println(item.getCatagory());

out.println(item.getPrice());
out.println(item.getDescription());

%>

<% if(isOwner){ %><a  href="ItemController?type=delete&id=<%=item.getId()%>">delete</a><br>
<%}
else{%><br>
<%

}
}
%>
<% if(isOwner){ %>
<a href="AddItem.jsp">Click Here to Add Item</a>
<%} %>

</body>
</html>