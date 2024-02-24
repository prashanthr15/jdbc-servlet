package com.prog.jdbc3;

import java.sql.*;

public class JDBC3 {

	public static void main(String[] args) throws Exception {
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
				
				Statement stmt =connect.createStatement();
				
				//String query="update studentdetail set age =23 where id=3";
				String query="delete from studentdetail where id=3";
				int rowsAffected=stmt.executeUpdate(query);
				if(rowsAffected!=0) {
					System.out.println("deleted succesfully");
				}else {
					System.out.println("failed to deleted");
				}
				
				stmt.close();
				connect.close();
				
	}

}
