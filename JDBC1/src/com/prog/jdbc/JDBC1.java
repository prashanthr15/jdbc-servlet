package com.prog.jdbc;

import java.sql.*;

public class JDBC1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver is registered");
		
		//establish the connection
		String url="jdbc:mysql://localhost:3306/prashanth_db";
		String userName="root";
		String password="621311";
		
		Connection connect=DriverManager.getConnection(url, userName, password);
		System.out.println("connection is established");
		
		//this createStatement() will carry the sql query
		
		Statement stmt=connect.createStatement();
		System.out.println("statement object is ready");
		
		
		String query="select * from studentdetail";
		ResultSet rs=stmt.executeQuery(query);
		System.out.println("we have got result set");
		System.out.println("id\tname\tage\tgender");
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +rs.getInt(3) + "\t" + rs.getString(4));
		}
		
		rs.close();
		stmt.close();
		connect.close();
		System.out.println("all closed");
		
	}

}
