package project.service.user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.connect.DAOClass;
import project.model.Product;



public class Search_Service 
{
	public List<Product> service(String search) throws ClassNotFoundException, SQLException
	{
		List<Product> list = new ArrayList<Product>();
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select * from products where pName=?");
		ps.setString(1, search);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
		}
		return list;
	}
}
