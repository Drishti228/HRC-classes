package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Crud {

	public Connection getConnection()
	{
		
		 Connection conn =null;
		 String url ="jdbc:mysql://localhost:3306/grey_goose?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";//jdbc:odbc:db_name
		 String user = "root";
		 String pass ="Drishti@1968";
			
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");//initialize and load jdbc odbc drivers
					
				}
				catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} 
				conn =DriverManager.getConnection(url,user,pass);
				System.out.println("Post establishing a dataBase Connection-"+conn);
			}
			catch (SQLException e) {
				System.out.println("Error");
					e.printStackTrace();
				}
				
				return conn;
			
		
		}
		
		
		
}