package com.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibCustomer extends LibUser 
{

	@Override
	public void userLogin() 
	{
		System.out.println("Customber has logged in!!");	
	}

	@Override
	public void viewBooks() 
	{
		try(Connection con=DatabaseConnection.getConnection())
		{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from books");
		while(rs.next())
		{
			System.out.println(rs.getInt("bkid")+"-"+rs.getString("bkname")+"-"+rs.getString("authname")+"-"+rs.getString("bkgener")+"-"+rs.getInt("bkqun"));
		}
		
	} catch (SQLException e)
		{
					e.printStackTrace();
	}
		
 }
	public void borrowbook(int bookId)
	{
		try(Connection con=DatabaseConnection.getConnection())
		{
		PreparedStatement ps=con.prepareStatement("update books set bkqun=bkqun-1 where bkid=? and bkqun>0");
		ps.setInt(1, bookId);
		int row=ps.executeUpdate();
		   if(row>0)
		   {
			   System.out.println("Book borrowed from library....");
		   }
		   else
		   {
			   System.out.println("Book not currently available.\n Please try later.");
		   }
		
	} catch (SQLException e)
		{
					e.printStackTrace();
	}
	}
public void returnBook(int bookId)
{
	try(Connection con=DatabaseConnection.getConnection())
	{
	PreparedStatement ps=con.prepareStatement("update books set bkqun=bkqun+1 where bkid=?");
	ps.setInt(1, bookId);
	int row=ps.executeUpdate();
	   if(row>0)
	   {
		   System.out.println("Book Returned\n Thankyou.");
	   }
	   else
	   {
		   System.out.println("Book not returned.\n Please try again.");
	   }
	
} catch (SQLException e)
	{
				e.printStackTrace();
}	
}
}
