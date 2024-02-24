package com.prog.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//setters ,getters ,constructer,to string
public class JdbcApp {

	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private int row;
	
	
	private PreparedStatement pstmt= null;
	private Connection connect = null;
	String query="insert into studentdetail (id, name, age, gender)values(?,?,?,?)";
	
	
	public int getRow() {
		return row;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//	public JdbcApp(Integer id, String name, Integer age, String gender) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.gender = gender;
//	}
	@Override
	public String toString() {
		return "JdbcApp [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	//getting code from jdbcutility
	
	
	
	public void jdbcRegister() {
	
	try {
		//for debuging purpose
		System.out.println(id + name + age + gender +"control in jdbc app");
		 connect = JDBCutillity.getDBConnection();
		 if(connect!=null) {
			   pstmt = connect.prepareStatement(query);
		 
			   if(pstmt!=null) {
				   pstmt.setInt(1, id);
				   pstmt.setString(2, name);
				   pstmt.setInt(3, age);
				   pstmt.setString(4, gender);
				   
				 row=   pstmt.executeUpdate();
				//for debuging purpose
				 //used execute instead of execute update
//				 boolean status=pstmt.execute();
//				 System.out.println(status);
//				 if(status) {
//					 System.out.println("ignore");
//				 }
//				 else
//				 {
//					 row=pstmt.getUpdateCount();
//				 }
				//for debuging purpose
				System.out.println(row + "jdbc row");
				
				   
			   }
			  
		 }
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (Exception ee) {
		// TODO Auto-generated catch block
		ee.printStackTrace();
	}
	
	finally {
		try {
			JDBCutillity.closeResource(connect, pstmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	}
	
}
