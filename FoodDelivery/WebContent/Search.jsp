<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is food menu</title>
</head>
<body>
Please enter the key word:
<form action="SearchController" method="post">
<input type="text" name=keywords ><br/>
<input type="submit" name="search_price" value="search by price">
<input type="submit" name="search_category" value="search by category">
<input type="submit" name="search_location" value="search by location">
<input type="submit" name="search_name" value="search by name">
</form>

</body>
</html>