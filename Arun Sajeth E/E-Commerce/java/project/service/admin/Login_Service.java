package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.connect.DAOClass;


public class Login_Service 
{
	public String userChecking(String user,String pass) throws ClassNotFoundException, SQLException
	{
		Connection con= DAOClass.getConnect();
		
		PreparedStatement ps = con.prepareStatement("select password,status from register where email=?");
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		String temp=null;
		if(rs.next())
		{
			if(pass.equals(rs.getString(1)) && rs.getString(2).equals("active"))
			{
				temp = "act";
			}
			else if(pass.equals(rs.getString(1)) && rs.getString(2).equals("inactive"))
			{
				temp = "Registation Under Process";
			}
			else if(pass.equals(rs.getString(1)) && rs.getString(2).equals("deactive"))
			{
				temp = "Your accout is deactivated";
			}
			else
			{
				temp = "Wrong Credentials";
			}
		}
		return temp;
	}
}
