<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="com.fooddelivery.model.*" %> 
<title>Login in success</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<% User user = (User)session.getAttribute("user");%>
<%if (user==null){%>
   <a href="index.html"><%out.println("Login here");%></a>
 	<%
	}
else %>
<h3>Welcome <%=user.getUsername()%></h3>
<%if (user.getRestaurantid()>0){ %>
<h4><a href="ItemController?type=view&id=<%=user.getRestaurantid()%>">My restaurant</a></h4>
<h4><a href="Search.jsp">Go To Search Page</a></h4>


<% }
else {%>

<h4><a href="Search.jsp">Go To Search Page</a></h4><%} %>
<h4><a href="ViewOrder.jsp">View My Order</a></h4>

</body>
</html>