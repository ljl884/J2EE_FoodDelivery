<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="com.fooddelivery.service.*" %> 
<%@ page import="java.util.*" %>
<% 
String name=(String)session.getAttribute("addname");
String catagory=(String)session.getAttribute("addcatagory");
int price=((Integer)session.getAttribute("addprice")).intValue();
String description=(String)session.getAttribute("adddescription");
int menu_id=((Integer)session.getAttribute("menu_id")).intValue();
ItemService is = new ItemService();
is.addItem(menu_id, name, catagory, price, description);
%>
AddItem Success
</body>
</html>