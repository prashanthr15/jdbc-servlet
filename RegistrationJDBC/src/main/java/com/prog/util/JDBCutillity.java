package com.prog.util;

import java.sql.*;

public class JDBCutillity {

	// the movement i load the class i want driver to be registered so, static block
	// is loaded when cls loads
	static {

		// load and register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("driver is registered");
	}

	// when i want connection to be established so use methods
	// i dont want to create instance so go for static method
	public static Connection getDBConnection() throws SQLException {

		// establish the connection
		String url = "jdbc:mysql://localhost:3306/prashanth_db";
		String userName = "root";
		String password = "621311";

		Connection connect = DriverManager.getConnection(url, userName, password);
		System.out.println("connection is established");

		return connect;
	}

	public static void closeResource(Connection connect, Statement stmt) throws SQLException {
		// not equal to null means there is a connection
		//if its equal to null and close the connection that means without any connection u closing the connection then it lead to null pointer exception
		//to avoid that we checking this
		if (connect != null)
			connect.close();

		if (stmt != null)
			stmt.close();

		
	}

}
