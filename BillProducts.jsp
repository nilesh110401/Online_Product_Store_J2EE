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
	productBean pb = (productBean)session.getAttribute("pb");
	
	int reQqty = (int)session.getAttribute("reqqty");
	out.println("Page belongs to: "+cb.getfName()+"<br>");
	out.println("Code: "+pb.getpCode()+"<br>"+"Name: "+pb.getpName()+"<br>"+"ReqQuantity: "+reQqty+"<br>");
	out.println("Total billing amount: "+pb.getpPrice()*reQqty+"<br>");
%>
	<!-- <a href="payment"> Payment</a> -->
	 <form action="payment" method="post">
	<input type="submit" value="Payment">
	
	
</form>
</body>
</html>