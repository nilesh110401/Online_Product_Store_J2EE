<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
	out.println("Page Belongs to: "+cb.getfName()+"<br>");
	out.println("Payment Successful....<br>");
	
%>
	<a href="cviewProducts">View All Products</a>
	<a href="logout">Logout</a>
</body>
</html>