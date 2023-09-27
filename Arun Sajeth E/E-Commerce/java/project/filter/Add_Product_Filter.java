package project.filter;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import project.service.admin.idChecking_Service;



@WebFilter("/Add_Product_Controller")
public class Add_Product_Filter extends HttpFilter implements Filter {
       
    
    public Add_Product_Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		int id=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("pName");
		String desp = request.getParameter("pDesp");
		double price = Double.parseDouble(request.getParameter("pPrice"));
		int quan= Integer.parseInt(request.getParameter("pQty"));
		
		idChecking_Service ics = new idChecking_Service();
		int temp=0;
		try {
			temp = ics.service(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(temp==0 &&name.length()>=3 && desp.length()>=10 && price>0 && quan>0)
		{
			chain.doFilter(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Add_Product.jsp");
			rd.include(request, response);
			response.getWriter().println("Invalid Registration");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
