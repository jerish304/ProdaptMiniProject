package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connect.DAOClass;
import project.model.Product;



public class Add_Product_Service 
{
	public String service(Product d) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("insert into products values (?,?,?,?,?)");
		ps.setInt(1, d.getPid());
		ps.setString(2, d.getpName());
		ps.setString(3, d.getpDesp());
		ps.setDouble(4, d.getpPrice());
		ps.setInt(5, d.getpQty());
		
		int temp = ps.executeUpdate();
		
		return "Product Created";
	}
}
