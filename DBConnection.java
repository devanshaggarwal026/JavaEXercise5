package com.robomq.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static Connection con;
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","devansh","Devansh@123");
			System.out.println("connected to database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
