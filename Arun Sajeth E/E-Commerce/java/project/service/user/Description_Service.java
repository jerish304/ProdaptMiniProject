package project.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.connect.DAOClass;
import project.model.Product;

public class Description_Service 
{
	public Product service(int id) throws ClassNotFoundException, SQLException
	{
		Product prod = null;
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select * from products where pid=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			prod = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
		}
		return prod;
	}
}
