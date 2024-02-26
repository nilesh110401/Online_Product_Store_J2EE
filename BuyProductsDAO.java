package test;

import java.sql.*;

public class BuyProductsDAO 
{
	public productBean pb = null;

	public productBean buy(String pCode)
	{
		try 
		{
			Connection con = DBConnection.getCon();
			// Accessing DB Connection
			PreparedStatement ps = con.prepareStatement("select * from Product55 where code=?");
			ps.setString(1, pCode);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pb = new productBean();
				
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setpPrice(rs.getInt(3));
				pb.setpQty(rs.getInt(4));
				
		}
	}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return pb;
}
}





//    public int buyProduct(String productCode, int quantityToBuy) {
//        int updatedQty = -1;
//
//        try {
//            Connection con = DBConnection.getCon();
//            PreparedStatement selectPs = con.prepareStatement("select pQty from Product55 where pCode = ?");
//            selectPs.setString(1, productCode);
//
//            ResultSet rs = selectPs.executeQuery();
//
//            if (rs.next()) {
//                int currentQty = rs.getInt("pQty");
//                if (currentQty >= quantityToBuy) {
//                    PreparedStatement updatePs = con.prepareStatement("update Product55 set pQty = ? where pCode = ?");
//                    updatePs.setInt(1, currentQty - quantityToBuy);
//                    updatePs.setString(2, productCode);
//
//                    int rowsUpdated = updatePs.executeUpdate();
//
//                    if (rowsUpdated > 0) {
//                        updatedQty = currentQty - quantityToBuy;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return updatedQty;
//    }
//}
