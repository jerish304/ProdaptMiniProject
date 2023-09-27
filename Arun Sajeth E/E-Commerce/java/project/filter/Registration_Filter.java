package project.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import project.service.admin.Registration_Service;


@WebFilter("/Registration_Controller")
public class Registration_Filter extends HttpFilter implements Filter {
       
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException

    {
            String fname = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("pwd");
            String mobile = request.getParameter("Phno");
            String dob = request.getParameter("dob");
            
        

            List<String> list=new ArrayList<>();

            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            java.util.Date user_date = null;
            java.util.Date check_date = null;

            try
            {
            	user_date = df.parse(dob);
                check_date = df.parse("2000");
            }
            catch (ParseException e)
            {
                response.getWriter().println("<html><h1><center>Invalid Date of Birth (Enter in dd-mm-yyyy format)</center></html>");
                request.getRequestDispatcher("Register.jsp").include(request, response);
                return; 
            }
            
            if (fname.length() > 2 && mobile.length() == 10 && user_date.before(check_date)&& Pattern.matches("[A-Za-z0-9]+@[a-zA-Z]+.[com,org,in,COM,IN,ORG]{2,6}", email)&& Pattern.matches("[A-za-z][a-zA-Z0-9_$*!@#^&]{7,15}", password))
            {
            	try 
            	{
					List<String> err = error(email);
					if(err.isEmpty())
					{
						chain.doFilter(request, response);
					}
				}
            	catch (Exception e) {
					
            		e.printStackTrace();
				}
            }
            
            try 
        	{
				List<String> err = error(email);
				if(!err.isEmpty())
				{
					list.add("Email already existing");
				}
			}
        	catch (Exception e) {
				
        		e.printStackTrace();
			}
            
            if (fname.length()<3)
            {
            	list.add("Name should be alteast 3 characters.");
            }
            if (user_date.after(check_date))
            {
                list.add("Date of Birth Year must be before 2000");
            }

            if (!Pattern.matches("[A-Za-z0-9]+@[a-zA-Z]+.[com,org,in,COM,ORG,IN]{2,6}", email))
            {
               list.add("Invalid Email ID");
            }

            if (!Pattern.matches("[A-za-z][a-zA-Z0-9_$*!@#^&]{8,15}", password))
            {
               list.add("Password should contain atleast 8 characters like alphanumeric and special characters.");
            }
            System.out.println(list);
            for(String s:list)
            {
            	response.getWriter().println(s+"<br>");
            }
            response.setContentType("text/html");
            request.getRequestDispatcher("Register.jsp").include(request, response);
    }
	
	public static List<String> error(String email) throws ClassNotFoundException, SQLException, Exception
	{
		Registration_Service rs = new Registration_Service();
		List<String> err =null;
		err = rs.emailchecking(email);
		System.out.println(err);
		return err;
	}

	

}
