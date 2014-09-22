<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="com.fooddelivery.model.*" %>
<%@ page import="com.fooddelivery.service.*" %>
<body>
<form action=ItemController method="post">
Name <input type="text" name=name><br>
Category <input type="text" name=catagory><br>
Price(input an integer) <input type="text" name=price><br>
Description <input type="text" name=description><br>
<input type="submit" value=add>
</form>
</body>
</html>