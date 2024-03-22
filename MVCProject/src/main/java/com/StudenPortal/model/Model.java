package com.StudenPortal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private String userName;
	private String city;
	private String country;
	private String password;
	private Connection connect = null;
	private PreparedStatement psmt = null;
	private int row;
	private ResultSet rs;
	
	
	
	//setters and getters 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//tostring
	@Override
	public String toString() {
		return "Model [userName=" + userName + ", city=" + city + ", country=" + country + ", password=" + password
				+ "]";
	}
	
	
	public int register() {
		
		try {
			System.out.println("control in register model");
			 connect = JdbcUtility.getDBConnection();
			 
			 if(connect!=null) {
				 String sql="insert into studentportal(id,username,city,country,password)"
						 +"values(?,?,?,?,?)";
				psmt=connect.prepareStatement(sql);
				if(psmt!=null) {
					psmt.setInt(1, 2);
					psmt.setString(2, userName);
					psmt.setString(3, city);
					psmt.setString(4, country);
					psmt.setString(5, password);
					row=psmt.executeUpdate();
					System.out.println(row +"row  in jdbc model");
				}
				
			 }
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				JdbcUtility.closeResource(connect, psmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public void login() {
		
		try {
			System.out.println("control in login model");
			 connect = JdbcUtility.getDBConnection();
			 
			 if(connect!=null) {
				 String sql= "SELECT username, password FROM prashanth_db.studentportal WHERE username = ?";
				psmt=connect.prepareStatement(sql);
				if(psmt!=null) {
					
					psmt.setString(1, userName);
					
					rs=psmt.executeQuery();
					System.out.println(row +"row  in jdbc model");
					while(rs.next()) {
						userName=rs.getString("username");
						password=rs.getString("password");
					}
					System.out.println("done with login verification");
				}
				
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
