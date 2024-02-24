package com.prog.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.prog.jdbc.util.JDBCutil6;

public class JDBCFectch9 {

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
//				stmt=connect.prepareStatement("update studentdetail set age=? where id=?");
				stmt=connect.prepareStatement("select * from studentdetail where id=?");

			if(stmt!=null) {
		
				System.out.println("welcome to my world");
				scan =new Scanner(System.in);
				
				
				System.out.println("please enter your id");
				Integer id = scan.nextInt();
				
				//in the first place holder(?) id 
			
				stmt.setInt(1, id);
				rs=stmt.executeQuery();
				if(rs!=null) {
					System.out.println("id\tname\tage\tgender");
					
					while(rs.next()) {
						
						System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +rs.getInt(3) + "\t" + rs.getString(4));
					}
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
