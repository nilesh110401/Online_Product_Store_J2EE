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
@WebServlet("/newcust")

public class NewCustomerServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		CustomerBean cb = new NewCustomerDAO().Register(req);
		if(cb==null)
		{
			req.setAttribute("msg","Invalid registration Process...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession(); // creating new session
			hs.setAttribute("cbean",cb);
			RequestDispatcher rd = req.getRequestDispatcher("RegSuccess.jsp");
			rd.forward(req, res);
			
		}
	}

}
