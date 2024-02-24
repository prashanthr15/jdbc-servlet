package com.prog.jdbc.main;

import java.sql.*;

import com.prog.jdbc.util.JDBCutil4;
public class JDBCmain5 {

	public static void main(String[] args) {
		Connection connect=null;
		Statement stmt = null;
		ResultSet rs= null;
		
		try 
		{
			//to avoid null pointer excption 
			connect=JDBCutil4.getDBConnection();
			//if its not null some object is there
			if(connect!=null)
				stmt=connect.createStatement();
//			if(stmt!=null)
//				//statement is java interface
//				//executequery is db vendor implemented
//				rs=stmt.executeQuery("select * from studentdetail");
//			if(rs!=null) {
//				System.out.println("id\tname\tage\tgender");
//				
//				while(rs.next()) {
//					
//					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +rs.getInt(3) + "\t" + rs.getString(4));
//				}
//			}
			
			
			if(stmt!=null) {
				//execute gives true (gives result set) or false (gives int row)
			boolean status=stmt.execute("update studentdetail set age =34 where id=4");
			if(status) {
				
				//resultset
				System.out.println("write resultset implementation to get data");
				rs= stmt.getResultSet();
				if(rs!=null) {
					System.out.println("id\tname\tage\tgender");
					
					while(rs.next()) {
						
						System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +rs.getInt(3) + "\t" + rs.getString(4));
					}
				}
			}
			else {
				System.out.println("get the update how namy rows affrcted");
				int rowsAffected= stmt.getUpdateCount() ;
				System.out.println(rowsAffected);
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
				JDBCutil4.closeResource(connect, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
