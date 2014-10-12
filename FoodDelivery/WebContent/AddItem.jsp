<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add an item</title>
</head>
<jsp:include page="header.jsp"/>
<%@ page import="com.fooddelivery.model.*" %>
<%@ page import="com.fooddelivery.service.*" %>
<body>
<form action=ItemController?method=add method="post" id="add">
Name <input type="text" name=name value="null"><br>
Category <input type="text" name=catagory value="null"><br>
Price(input an integer) <input type="text" name=price value="0"><br>
Description <input type="text" name=description value="null"><br>
Stock(input an integer) <input type="text" name=stock value="0"><br>
<input type="submit" value=add>
</form>
</body>
</html>