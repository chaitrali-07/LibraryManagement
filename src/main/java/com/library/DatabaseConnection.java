package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
   public static Connection getConnection() throws SQLException 
   {
	   String url="jdbc:postgressql://localhost:5432/library_db";
	   String user="postgres";
	   String password="12345";
	return DriverManager.getConnection(url,user,password);
	   
   }
}
