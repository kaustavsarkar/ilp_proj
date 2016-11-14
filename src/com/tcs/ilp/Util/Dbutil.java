package com.tcs.ilp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbutil {


	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String USERNAME = "system";
	private static final String PASSWORD = "kaustav";

	
	/*private String driver = "oracle.jdbc.driver.OracleDriver";
	private String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
	private String dbUserName = "system";
	private String dbPassword = "kaustav";
	private Connection con = null;
	PreparedStatement st = null;*/
	
	//creating Sql connection
	public static Connection getConnection(){
		Connection con = null;
		
		try {
			 Class.forName(DRIVER_NAME);
			 con  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
		    	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
		
	}

	
public static void closeAll(Connection con,ResultSet rs,PreparedStatement PS){

//closing result set

	if(rs!=null){
		try{
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	

//closing prepared Statement

	if(PS !=null){
		try{
			PS.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
	
	//closing connection 
	if(con!=null){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
} 

public static void closeAll(Connection con,ResultSet rs,PreparedStatement PS,PreparedStatement seqPS){
	
//closing result set

	if(rs!=null){
		try{
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	

//closing prepared Statements

	if(PS !=null){
		try{
			PS.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
	
	if(seqPS !=null){
		try{
			seqPS.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
	}
	//closing connection 
	if(con!=null){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
} 


}


