<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%@ page import="com.fooddelivery.service.*" %> 
<%@ page import="com.fooddelivery.model.*" %> 
<%@ page import="java.util.*" %>
<% 
User user =(User)session.getAttribute("user");
String name=(String)request.getSession().getAttribute("addname");
String catagory=(String)request.getSession().getAttribute("addcatagory");
int price=((Integer)request.getSession().getAttribute("addprice")).intValue();
String description=(String)request.getSession().getAttribute("adddescription");
int menu_id=((Integer)request.getSession().getAttribute("menu_id")).intValue();
ItemService is = new ItemService();
is.addItem(menu_id, name, catagory, price, description);
%>
AddItem Success
<a href="ItemController?type=view&id=<%=user.getRestaurantid()%>">back</a>
</body>
</html>