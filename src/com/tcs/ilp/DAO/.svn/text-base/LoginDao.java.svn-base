package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.POJO.User;
import com.tcs.ilp.Util.Dbutil;



public class LoginDao {
	
	public User  login(String username,String password) {
		//creating connection,prepared statement,resultset
		Connection con=Dbutil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println(username+"::"+password+"\n");
		
		User user=new User();
		//query to select user based on username and password
		String query="SELECT * FROM USER_REGISTRATION_F WHERE Email='"+username+"' AND PASSWORD='"+password+"'";

		
		try{
			ps=con.prepareStatement(query);	
			
			rs=ps.executeQuery();
		
			//checking if any user data matches with login details
			if(rs!=null){
		
			while(rs.next()){
						
				user.setUser_Id(rs.getInt("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setDob(rs.getDate("DOB").toString());
				user.setGender(rs.getString("GENDER"));
				user.setEmail(rs.getString("EMAIL"));
				user.setAddress(rs.getString("ADDRESS")); 
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setZipcode(rs.getLong("ZIPCODE"));
				user.setPhone(rs.getLong("PHONE"));
				user.setCategory(rs.getString("CATEGORY"));
				
				
				
			}
			}
			else{
				System.out.println("rs is null"+username+"::"+password);
			}
		}catch(SQLException e){
			System.out.println("hello\n");
			e.printStackTrace();
		}
	
		finally{
			//closing all opened statement and connections
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			*/
		}
		
		return user;
	}
	
	

}
