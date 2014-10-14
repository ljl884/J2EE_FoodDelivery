<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
  <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<p align="left"><% User user = (User)session.getAttribute("user");%>

<%
boolean isOwner=false;
int user_restaurant = 0;
if (user==null){%>
   <a href="index.html">Login Here</a>
 <%
	}
else {
	user_restaurant=user.getRestaurantid();
	if(user_restaurant==1)
		isOwner=true;
	%><a href="success.jsp"><%=user.getUsername() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.html">Logout</a></p><%} %>
	
	