package com.prog.jdbc.main;

import java.sql.*;
import java.util.Scanner;

import com.prog.jdbc.util.JDBCutil10;
public class JDBC9 {

	
	public static void main(String[] args) {
		
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		Scanner scan = null;
		
		try {
		connect =	JDBCutil10.getDBConnection();
		if(connect!=null) {
			String query="update studentdetail set age=? where id=?";
			stmt= connect.prepareStatement(query);
		}
		if(stmt!=null) {
//			scan= new Scanner(System.in);
//			System.out.println("enter id");
//			int id = scan.nextInt();
//			System.out.println("enter age");
//			int age = scan.nextInt();
			
			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.addBatch();
			
			stmt.setInt(1, 2);
			stmt.setInt(2,2);
			stmt.addBatch();
			
			
			stmt.setInt(1, 3);
			stmt.setInt(2,3);
			stmt.addBatch();
			
			stmt.setInt(1, 4);
			stmt.setInt(2, 4);
			stmt.addBatch();
			
			stmt.setInt(1, 5);
			stmt.setInt(2, 5);
			stmt.addBatch();
			
			stmt.executeBatch();
			System.out.println("check db for update");
		}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCutil10.closeResource(connect, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
