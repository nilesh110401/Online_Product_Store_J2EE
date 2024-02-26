<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.*,java.util.*"
    import = "test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<productBean> al = (ArrayList<productBean>)session.getAttribute("al");
out.println("Welcome :"+ab.getfName()+"<br>");
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
		out.println(pb.getpCode()+"&nbsp&nbsp"+pb.getpName()+"&nbsp&nbsp"+pb.getpPrice()+"&nbsp&nbsp"+pb.getpQty()+"&nbsp&nbsp"+"<a href ='editProduct?pcode="+pb.getpCode()+"'>Edit</a>"+"&nbsp&nbsp"+"<a href = 'deleteProduct?pcode="+pb.getpCode()+"'>Delete</a>"+"<br>");
	}
}
%>

<a href = "product.html">AddProduct</a>
<a href = "logout">Logout</a>
</body>
</html>