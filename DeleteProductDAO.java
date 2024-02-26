package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {

	public int k=0;
	public int delete(String pCode)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from Product55 where code = ?");
			ps.setString(1, pCode);
			k = ps.executeUpdate();
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return k;
	}
}
