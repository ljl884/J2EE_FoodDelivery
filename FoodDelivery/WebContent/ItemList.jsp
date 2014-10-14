<%@page import="com.fooddelivery.service.RestaurantService"%>
<%@page import="com.fooddelivery.datasource.MenuMapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item List</title>
</head>
<body>
<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
<jsp:include page="header.jsp"/>
<% User user = (User)session.getAttribute("user");%>
<%

boolean isOwner=false;
int user_restaurant = 0;
RestaurantService rs=new RestaurantService();

if (user==null){%>
   
 <%
	}
else {
	user_restaurant=user.getRestaurantid();
	//out.println(request.getAttribute("restaurantID"));
	if(user_restaurant==Integer.parseInt(request.getAttribute("restaurantID").toString()))
		isOwner=true;
	}
%>
<h3>Searching Results</h3>

<%
session.setAttribute("res_id","1");
session.setAttribute("user_id",""+user.getId());
//request.setAttribute("res_id",1);
 %>
<form class="form-horizontal" action="ItemController?method=buy" method="post" id="buy">


<%
ArrayList<Item> list=new ArrayList<Item>();
list = (ArrayList<Item>)request.getAttribute("result");	
int restaurantid = 0;
if(list.get(0)!=null){
	restaurantid = rs.getRestaurantIdByItemId(list.get(0).getId());
}
%>
<div class="col-lg-12">
<div class="bs-component">
<table class="table table-striped table-hover">
<thead>
<tr>
<th>#</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Description</th>
<th>Stock</th>
<th>Operation</th>
</tr>
</thead>
<tbody>
	<%for(Item item:list) {%>
	<tr>
		<td><%=item.getId() %></td>
		<td><%=item.getName() %></td>
		<td><%=item.getCatagory() %></td>
		<td><%=item.getPrice() %></td>
		<td><%=item.getDescription() %></td>
		<td><%=item.getStock() %></td>
		<%if(isOwner){ %>
		<td>
			<a  class="btn btn-primary" href="ModifyItem.jsp?id=<%=item.getId()%>">UPDATE</a>
			<a  class="btn btn-danger" href="ItemController?type=delete&id=<%=item.getId()%>">DELETE</a>
			
		</td>
		<%}else if(user_restaurant==0) {%>
		<td><div class="form-group has-success">
		
		<input class="form-control col-lg-1" id="inputSuccess" type="text" name=<%=item.getId()%> value=0>
		</div><td>
		<%} %>
	</tr>
	<%} %>
</tbody>
</table>
</div>
</div>
<input type="hidden" name="userid" value=<%=user.getId() %>>
<input type="hidden" name="restaurantid" value=<%=restaurantid%>>

<%
if(user_restaurant==0){ %>
<input class="btn btn-success" type="submit" value=buy>
<%}

%>
</form>

<% if(isOwner){ %>
<a class="btn btn-success" href="AddItem.jsp">Click Here to Add a New Item</a>
<%} %>

</body>
</html>