<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
	ArrayList<productBean> al = (ArrayList<productBean>)session.getAttribute("al");
	out.println("Welcome : "+cb.getfName()+"<br>");
	
	if(al.size()==0)
	{
		out.println("Products Not Avalaible...<br>");
	}
	else
	{
		Iterator<productBean> it = al.iterator();
		while(it.hasNext())
		{
			productBean pb = (productBean)it.next();
			out.println(pb.getpCode()+"&nbsp&nbsp"+pb.getpName()+"&nbsp&nbsp"+pb.getpPrice()+"&nbsp&nbsp"+pb.getpQty()+"&nbsp&nbsp"+"<a href ='buyProduct?code="+pb.getpCode()+"&qty="+pb.getpQty()+"'>Buy</a><br>");
	}
}
%>
	<a href="logout">Logout</a>
</body>
</html>