package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllProductDAO {
	
	public ArrayList<productBean> al = new ArrayList<productBean>();
	
	public ArrayList<productBean> retrieve()
	{
		try 
		{
			Connection con = DBConnection.getCon();
			// Accessing database connection
			
			PreparedStatement ps = con.prepareStatement("select * from Product55");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				productBean pb = new productBean();
				
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setpPrice(rs.getFloat(3));
				pb.setpQty(rs.getInt(4));
				al.add(pb); // Adding productBean object to ArrayList
				
			} // end of while
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return al;
	}

}
