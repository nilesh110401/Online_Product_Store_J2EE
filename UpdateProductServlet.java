package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		} else {
			String pCode = req.getParameter("code");
			
			ArrayList<productBean> al = (ArrayList<productBean>)hs.getAttribute("al");
			Iterator<productBean> it = al.iterator();
			
			while(it.hasNext()) {
				productBean pb = (productBean)it.next();
				
				if(pCode.equals(pb.getpCode()))
				{
					pb.setpPrice(Float.parseFloat(req.getParameter("price")));
					pb.setpQty(Integer.parseInt(req.getParameter("qty")));
					int k = new UpdateProductDAO().update(pb);
					
					if(k>0)
					{
						req.setAttribute("msg", "Product Updated Successfully...<br>");
					} // end of if
					break;
				} // end of if
				
			} // end of loop
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
	}
}
