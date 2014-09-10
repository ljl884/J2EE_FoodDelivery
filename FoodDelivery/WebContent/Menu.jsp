<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is food menu</title>
</head>
<body>
hahahahahahhahahahaha

<a href="SimpleForm.html">Login Page</a>
 <form action="MenuController" method="post">
 <%@ page import="com.fooddelivery.presentation.MenuController" %>
 <%@ page import="com.fooddelivery.model.User" %>
 <% User user = (User)session.getAttribute("user");%>
 Welcome <%=user.getUsername()%>
  <input type="submit" value="<%=user.getUsername()%>">
 </form>
</body>
</html>