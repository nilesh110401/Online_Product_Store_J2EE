package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;

public class NewCustomerDAO 
{
	public CustomerBean cb = null;
	
	public CustomerBean Register(HttpServletRequest req)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO CustomerTab55 VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword")); 
			ps.setString(3, req.getParameter("fname")); 
			ps.setString(4, req.getParameter("lname")); 
			ps.setString(5, req.getParameter("add")); 
			ps.setString(6, req.getParameter("mid")); 
			ps.setString(7, req.getParameter("phno")); 
			
			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
	            // If needed, perform a SELECT to get the inserted data
	            // Example: SELECT * FROM CustomerTab55 WHERE uname = ?
	            // Set the retrieved data in the CustomerBean
	            cb = new CustomerBean();
	            cb.setuName(req.getParameter("uname"));
	            cb.setpWord(req.getParameter("pword"));
	            cb.setfName(req.getParameter("fname"));
	            cb.setlName(req.getParameter("lname"));
	            cb.setAddr(req.getParameter("add"));
	            cb.setmId(req.getParameter("mid"));
	            cb.setPhNo(Long.parseLong(req.getParameter("phno")));
	        }
				
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return cb;
	}

}
