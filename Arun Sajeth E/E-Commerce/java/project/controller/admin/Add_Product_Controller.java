package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.Product;
import project.service.admin.Add_Product_Service;




@WebServlet("/Add_Product_Controller")
public class Add_Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Add_Product_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("pName");
		String desp = request.getParameter("pDesp");
		double price = Double.parseDouble(request.getParameter("pPrice"));
		int quan= Integer.parseInt(request.getParameter("pQty"));
		Add_Product_Service ads = new Add_Product_Service();
		Product d = new Product(id,name,desp,price,quan);
		
		System.out.println(d);
		String result=null;
		try {
			result=ads.service(d);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Add_Product.jsp");
			rd.include(request, response);
			response.getWriter().println("<h3><center>PRODUCT CREATED</center></h3>");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Add_Product.jsp");
			rd.include(request, response);
			response.getWriter().println("<h3><center>PRODUCT NOT CREATED SOMETHING WENT WRONG</center></h3");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
