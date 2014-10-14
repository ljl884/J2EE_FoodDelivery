<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RestaurantList</title>
</head>
<body> 
<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
<%
ArrayList<Restaurant> list=new ArrayList<Restaurant>();
if(request.getAttribute("nam_result")!=null){
	list = (ArrayList<Restaurant>)request.getAttribute("nam_result");	
}
if(request.getAttribute("pri_result")!=null){
	list = (ArrayList<Restaurant>)request.getAttribute("pri_result");
}
if(request.getAttribute("loc_result")!=null){
	list = (ArrayList<Restaurant>)request.getAttribute("loc_result");
}
if(request.getAttribute("cat_result")!=null){
	list = (ArrayList<Restaurant>)request.getAttribute("cat_result");
}
%>
<jsp:include page="header.jsp"/>
<h3>Searching Results</h3>


<div class="col-lg-12">
<div class="bs-component">
<table class="table table-striped table-hover">
<thead>
<tr>
<th>#</th>
<th>Name</th>
<th>Category</th>
<th>Location</th>
<th>Average Price</th>
</tr>
</thead>
<tbody>
	<%for(Restaurant restaurant:list) {%>
	<tr>
		<td><%=restaurant.getId() %></td>
		<td><a href="ItemController?type=view&id=<%=restaurant.getId() %>"><%=restaurant.getName() %></td>
		<td><%=restaurant.getCategory() %></td>
		<td><%=restaurant.getLocation()%></td>
		<td><%=restaurant.getAverageprice()%></td>
		
		
		
	</tr>
	<%} %>
</tbody>
</table>
</div>
</div>


</body>
</html>