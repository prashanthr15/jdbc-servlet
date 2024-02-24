package com.prog.jdbc.main;
import java.sql.*;
import java.util.Scanner;

import com.prog.jdbc.util.JDBCutil6;


public class JDBCinsert7 {

	public static void main(String[] args) {
		
		Connection connect=null;
		PreparedStatement stmt = null;
		Scanner scan= null;
		ResultSet rs=null;
		
		//to avoid null pointer excption 
		try {
			connect=JDBCutil6.getDBConnection();
			//to avoid null pointer exception
			if(connect!=null) {
				//prepareStatement is in complete query. here we can give the values at run time
				//statement wecan hard code 
				String query="insert into studentdetail(id,name,age,gender)"
			+"values(?,?,?,?)";
				stmt=connect.prepareStatement(query);
			}
			if(stmt!=null) {
				System.out.println("welcome to my world");
				scan =new Scanner(System.in);
				System.out.println("please enter your id");
				Integer id = scan.nextInt();
				System.out.println("please enter your name");
				String name= scan.next();
				System.out.println("please enter your age");
				Integer age = scan.nextInt();
				System.out.println("please enter your gender");
				String gender= scan.next();
				
				
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setInt(3, age);
				stmt.setString(4, gender);
				
				int rowsAffected=stmt.executeUpdate();
				if(rowsAffected!=0) {
					System.out.println("registration successful");
				}
				else {
					System.out.println("fail to register");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				JDBCutil6.closeResource(connect, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
