package project.service.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.connect.DAOClass;
import project.model.Registration;



public class Registration_Service 
{
	public void service(Registration reg) throws ClassNotFoundException, SQLException
	{
		System.out.println("HHHHHHHHehh");
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
		ps.setString(1, reg.getName());
		ps.setDate(2, new java.sql.Date(reg.getDob().getTime()));
		ps.setString(3, reg.getEmail());
		ps.setString(4, reg.getPhno());
		ps.setString(5, reg.getPass());
		ps.setString(6, "inactive");
		ps.executeUpdate();
		
	}
	
	public List<String> emailchecking(String email) throws ClassNotFoundException, SQLException
	{
		List<String> err = new ArrayList<String>();
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select email from register where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			err.add(rs.getString(1));
		}
		System.out.println(1111111);
		System.out.println(err);
		return err;
	}
}
