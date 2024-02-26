<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.*"%>
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
	
//	String ms = (String)request.getAttribute("msg");
	out.println("Page belongs to "+cb.getfName()+"<br>");
	//out.println(ms);

	out.println("Code:"+pb.getpCode()+"<br>"+"Name:"+pb.getpName()+"<br>"+"Price:"+pb.getpPrice()+"<br>"+"Quantity:"+pb.getpQty()+"<br>");
	session.setAttribute("pb", pb);
%>	

	<form action="billProducts" method="post">
	RequiredQuantity:<input type="text" name="reqqty"><br>	
	<input type="submit" value="BuyProduct">
	</form>
	
	

</body>
</html>