package com.library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends LibUser {
	 @Override
		public void userLogin() 
	   {
		System.out.println("User has logged in !! ");	
		}

		@Override
		public void viewBooks() {
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
		


   public void addBook(LibBook book) throws SQLException
   {
	   try(Connection con=DatabaseConnection.getConnection()) 
	   {
	    PreparedStatement ps=con.prepareStatement("Insert into books(bkid,bkname,authname,bkgener,bkqun) values(?,?,?,?,?)");
	    ps.setInt(1, book.getBkid());
	    ps.setString(2, book.getBkname());
	    ps.setString(3, book.getAuthname());
	    ps.setString(4, book.getBkgener());
	    ps.setInt(5, book.getBkqun());
	    ps.executeUpdate();
	    System.out.println("Book is addded");
   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
}
   public void removeBook(int bookId)
   {
	   try(Connection con=DatabaseConnection.getConnection()) 
	   {
	    PreparedStatement ps=con.prepareStatement("Delete from books where bkid=? ");
	    ps.setInt(1, bookId);
	    ps.executeUpdate();
	    System.out.println("Book removed");
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
}