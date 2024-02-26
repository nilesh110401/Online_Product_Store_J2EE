package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/buyProduct")
public class BuyProductsServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        HttpSession hs = req.getSession(false);

        if (hs == null) {
            req.setAttribute("msg", "Session Expired...<br>");
            RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
            rd.forward(req, res);
        } else {
            String pCode = req.getParameter("code");
//            int quantityToBuy = Integer.parseInt(req.getParameter("reqqty"));

//            BuyProductsDAO buyProductDAO = new BuyProductsDAO();
//            int updatedQty = buyProductDAO.buyProduct(productCode, quantityToBuy);

//            if (updatedQty >= 0) {
//                req.setAttribute("msg", "Product Bought Successfully..<br>");
//                res.sendRedirect("BuyProducts.jsp");
//            } else {
//                req.setAttribute("msg", "Failed to buy the product. Not enough quantity available.<br>");
//                res.sendRedirect("BuyProducts.jsp");
//            }
            productBean pbean = new BuyProductsDAO().buy(pCode);
            
            hs.setAttribute("pb",pbean);
            RequestDispatcher rd = req.getRequestDispatcher("BuyProducts.jsp");
    		rd.forward(req, res);
        }
        
    }
}
