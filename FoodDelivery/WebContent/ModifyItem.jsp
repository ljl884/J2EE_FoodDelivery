<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Item</title>
</head>
<jsp:include page="header.jsp"/>
<%@ page import="com.fooddelivery.model.*" %>
<%@ page import="com.fooddelivery.service.*" %>
<body>
<%		String search_id=request.getParameter("id");
		int new_id=Integer.parseInt(search_id);
		request.getSession().setAttribute("mod_id", new_id);
		//System.err.println("new_id"+new_id);
       ItemService is=new ItemService();
       is.getItemById(new_id);
%>
<b>Please input the new value you want</b>
<form action=ItemController?method=mod method="post" id="mod">
Price(input an integer) <input type="text" name=price value=<%=is.getItemById(new_id).getPrice()%>><br>
Stock(input an integer) <input type="text" name=stock value=<%=is.getItemById(new_id).getStock()%>><br>
<input type="submit" value=modify>
</form>
</body>
</html>