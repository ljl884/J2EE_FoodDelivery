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
<p align="right"><% User user = (User)session.getAttribute("user");%>
<%if (user==null){%>
   <a href="index.html">Login Here</a>
 <%
	}
else 
	out.println("User:"+user.getUsername());%></p>
<h3>Searching Results</h3>
<p>Restaurant_Id &nbsp;&nbsp;  Restaurant_Name  &nbsp;&nbsp; Restaurant_Category &nbsp;&nbsp;  Restaurant_Location  &nbsp;&nbsp; Restaurant_AveragePrice</p>
<%
for(Restaurant restaurant:list) {
int id=restaurant.getId();

%>

<a href="ItemController?id=<%=id %>">
<%out.println(restaurant.getId());%>

<% out.println(restaurant.getName());

out.println(restaurant.getCategory());

out.println(restaurant.getLocation());
out.println(restaurant.getAverageprice());
%>
</a>
<br>
<%
}
%>

</body>
</html>