<%@page import="com.fooddelivery.service.RestaurantService"%>
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
<p>Id&nbsp;&nbsp;Name&nbsp;&nbsp;Category&nbsp;&nbsp;Price&nbsp;&nbsp;Description&nbsp;&nbsp;Stock&nbsp;&nbsp;How many you want buy </p>
<%
session.setAttribute("res_id","1");
session.setAttribute("user_id",""+user.getId());
//request.setAttribute("res_id",1);
 %>
<form action="ItemController?method=buy" method="post" id="buy">


<%
ArrayList<Item> list=new ArrayList<Item>();
list = (ArrayList<Item>)request.getAttribute("result");	
int restaurantid = 0;
if(list.get(0)!=null){
	restaurantid = rs.getRestaurantIdByItemId(list.get(0).getId());
}
%>
<input type="hidden" name="userid" value=<%=user.getId() %>>
<input type="hidden" name="restaurantid" value=<%=restaurantid%>>
<% for(Item item:list) {
out.println(item.getId());

out.println(item.getName());

out.println(item.getCatagory());

out.println(item.getPrice());
out.println(item.getDescription());
out.println(item.getStock());
%>

<% if(isOwner){ %><a  href="ItemController?type=delete&id=<%=item.getId()%>">delete</a>&nbsp;&nbsp;&nbsp;&nbsp;

<%} if(isOwner){ %><a  href="ModifyItem.jsp?id=<%=item.getId()%>">modify</a><br>



<%}
else if(user_restaurant==0){ %>
<input type="text" name=<%=item.getId()%> value=0><br>


	
<%
}
else{%><br>
<%

}
}
%>
<%
if(user_restaurant==0){ %>
<input type="submit" value=buy>
<%}

%>
</form>

<% if(isOwner){ %>
<a href="AddItem.jsp">Click Here to Add Item</a>
<%} %>

</body>
</html>