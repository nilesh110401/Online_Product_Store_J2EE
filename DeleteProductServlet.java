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
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		} else {
			String pCode = req.getParameter("pcode");
			
			ArrayList<productBean> al = (ArrayList<productBean>)hs.getAttribute("al");
			Iterator<productBean> it = al.iterator();
			
			while(it.hasNext())
			{
				productBean pb = (productBean)it.next();
				if(pCode.equals(pb.getpCode()))
				{
					it.remove();
					break;
				} // end of if
			} // end of loop
			
			int k = new DeleteProductDAO().delete(pCode);
			if(k>0)
			{
				req.setAttribute("msg", "Product Deleted Successfully...<br>");
			}
			
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		}
		
	}

	
}
