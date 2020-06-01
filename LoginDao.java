package com.Authenticate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	String url = "jdbc:mysql://localhost:3306/login_module";
	String username = "root";
	String password = "root";
	String sql = "select * from login where uname=? and pass=?";
	
	public boolean check(String uname, String pass) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url,username, password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs =st.executeQuery();
			if(rs.next()) {
				
				return true;
			}
			 
				
		}
			catch(Exception e){
			
				System.out.println(e);
			}
		return false;
		
	}
}
