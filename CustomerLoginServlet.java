package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/clogin")
public class CustomerLoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		CustomerBean cb = new CustomerLoginDAO().login(req);
		if(cb==null)
		{
			req.setAttribute("msg","Invalid login Process...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession(); // creating new session
			hs.setAttribute("cbean",cb);
			RequestDispatcher rd = req.getRequestDispatcher("CustomerLogSuccess.jsp");
			rd.forward(req, res);
			
		}
	}

}
