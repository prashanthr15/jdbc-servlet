package com.prog.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.prog.jdbc.util.JDBCutil6;

public class JDBCupdate8 {

	public static void main(String[] args) {
		Connection connect=null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		Scanner scan = null;
		
		try 
		{
			//to avoid null pointer excption 
			connect=JDBCutil6.getDBConnection();
			//if its not null some object is there
			if(connect!=null)
				stmt=connect.prepareStatement("update studentdetail set age=? where id=?");
			if(stmt!=null) {
		
				System.out.println("welcome to my world");
				scan =new Scanner(System.in);
				
				System.out.println("please enter your age");
				Integer age = scan.nextInt();
				System.out.println("please enter your id");
				Integer id = scan.nextInt();
				
				//in the first place holder(?) age and 2 place holder id
				stmt.setInt(1, age);
				stmt.setInt(2, id);
				
				int rowsAffected=stmt.executeUpdate();
				if(rowsAffected!=0) {
					System.out.println("registration successful");
				}
				else {
					System.out.println("fail to register");
				}
				
			}
			
		}
		catch(SQLException e) 
		{
			
			e.printStackTrace();
		}
	    catch(Exception ee) 
		{
			
			ee.printStackTrace();
		}
		
		
		finally 
		{
		
			try {
				JDBCutil6.closeResource(connect, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
