package com.prog.jdbc2;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is registered");
		
		//establish the connection
		String url="jdbc:mysql://localhost:3306/prashanth_db";
		String userName="root";
		String password="621311";
		
		Connection connect=DriverManager.getConnection(url, userName, password);
		System.out.println("connection is established");
		
		Statement stmt =connect.createStatement();
		
		String query = "insert into studentdetail(id,name,age,gender)"
				+"values(4,'shramik',22,'m')";
		 int rowAffected=stmt.executeUpdate(query);
		 System.out.println("query is good" +rowAffected);
		 
		 if(rowAffected!=0) {
			 System.out.println("check db data is added");
		 }
		 else {
			 System.out.println("fail to add");
		 }
		 
		 stmt.close();
		 connect.close();
		 

	}

}
