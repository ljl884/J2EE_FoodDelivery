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
<form class="form-horizontal" action=ItemController?method=add method="post" id="add">
<fieldset>
<legend>AddItem</legend>
<div class="formgroup">
	<lable for="inputName" class="col-lg-2 control-label">Name</lable>
	<div class="col-lg-10">
	<input type="text" class="form-control" name=name  placeholder="Name" id="inputName">
	</div>
</div>
<div class="formgroup">
	<lable for="inputCategory" class="col-lg-2 control-label">Category</lable>
	<div class="col-lg-10">
	<input type="text" class="form-control" name=category  placeholder="category" id="inputCategory">
	</div>
</div>
<div class="formgroup">
	<lable for="inputPrice" class="col-lg-2 control-label">Price</lable>
	<div class="col-lg-10">
	<input type="text" class="form-control" name=price value="0" placeholder="0" id="inputPrice">
	</div>
</div>
<div class="formgroup">
	<lable for="inputDescription" class="col-lg-2 control-label">Description</lable>
	<div class="col-lg-10">
	<input type="text" class="form-control" name=description  placeholder="Description" id="inputDescription">
	</div>
</div>
<div class="formgroup">
	<lable for="inputStock" class="col-lg-2 control-label">Stock</lable>
	<div class="col-lg-10">
	<input type="text" class="form-control" name=stock value="0" placeholder="0" id="inputStock">
	</div>
</div>
<input  class="btn btn-primary" type="submit" value=add>
</fieldset>



</form>
</body>
</html>