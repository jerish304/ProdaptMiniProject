package project.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.connect.DAOClass;
import project.model.Product;



public class DisplayWishList_Service 
{
	public List<Product> display(List<Integer> wishlist) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		List<Product> displist = new ArrayList<Product>();
		for(int i:wishlist)
		{
			PreparedStatement ps = con.prepareStatement("select * from products where pid =?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				displist.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
			}
			
		}
		return displist;
	}
}
