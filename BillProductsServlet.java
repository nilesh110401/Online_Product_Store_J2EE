package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/billProducts")
public class BillProductsServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
					rd.forward(req, res); 
		}
		else
		{
			int requireqty = Integer.parseInt(req.getParameter("reqqty"));
			hs.setAttribute("reqqty", requireqty);
			
			productBean pb = (productBean)hs.getAttribute("pb");
			hs.setAttribute("pb", pb);
			
			RequestDispatcher rd = req.getRequestDispatcher("BillProducts.jsp");
			rd.forward(req, res);
		}
	}

}
