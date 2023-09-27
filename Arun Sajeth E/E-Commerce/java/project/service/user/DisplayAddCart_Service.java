package project.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.connect.DAOClass;
import project.model.Product;


public class DisplayAddCart_Service 
{
	public List service(String mail) throws ClassNotFoundException, SQLException
	{
		List<Integer> list1 = new ArrayList<Integer>();
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select pid from addcart where email=?");
		ps.setString(1, mail);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list1.add(rs.getInt(1));
		}
		return list1;
	}
	
	public List service1(String mail) throws ClassNotFoundException, SQLException
	{
		List<Integer> list2 = new ArrayList<Integer>();
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select quantity from addcart where email=?");
		ps.setString(1, mail);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list2.add(rs.getInt(1));
		}
		return list2;
	}
	
	public List<Product> display(List<Integer> list1) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		List<Product> list = new ArrayList<>();
		for(int i:list1)
		{
			PreparedStatement ps = con.prepareStatement("select * from products where pid=?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
			}
		}
		return list;
	}
}
