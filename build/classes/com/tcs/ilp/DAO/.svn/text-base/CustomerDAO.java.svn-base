package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tcs.ilp.POJO.Items;
import com.tcs.ilp.POJO.User;
import com.tcs.ilp.Util.Dbutil;

public class CustomerDAO {
	
	
	 Connection con=Dbutil.getConnection();
	ResultSet rs=null;
	User customer=new User();
	
	PreparedStatement ps=null;
	public  ArrayList<Items> getItemsFromDepartment(String Name){
		ArrayList<Items> items=new ArrayList<Items>();
		
		String sql="SELECT * FROM ITEM_F WHERE DEPARTMENTID IN(SELECT DEPARTMENTID FROM DEPARTMENT_F WHERE DEPARTMENTNAME LIKE '%"+Name.toUpperCase()+"%')";
		try{
		ps=con.prepareStatement(sql);
		//ps.setString(1, Name);
		 rs=ps.executeQuery();
		if(rs!=null){
			while(rs.next()){
				Items item=new Items();
				item.setItemId(rs.getInt("itemid"));
				item.setItemName(rs.getString("itemname"));
				item.setDepartmentId(rs.getInt("departmentId"));
				item.setPrice(rs.getDouble("price"));
				item.setQuantity(rs.getInt("quantity"));
				items.add(item);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			*/
			
		}
		return items;
		
	}
	
public ArrayList<User> viewallDetails(){
		ArrayList<User> UserList=new ArrayList<User>();
		String sql="select * from USER_REGISTRATION_F where category='CUSTOMER' order by ID ";
		try{
			System.out.println("before query");
			ps=con.prepareStatement(sql);
			System.out.println("inside cust dao");
			rs=ps.executeQuery();
			if(UserList!=null){
			while(rs.next()){
				User user=new User();
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
				UserList.add(user);
			}
			}
				
		}
		catch(SQLException e){
			System.out.println("dao exception");
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			*/
		}
		return UserList;
	}
	
	//delete a customer 
	public int deleteUser(int Id) {
		int delete = 0;
		
		
		try {
			
			 ps = con.prepareStatement("delete USER_REGISTRATION_F where ID=?");
		     ps.setInt(1, Id);
		     
			 delete = ps.executeUpdate();
			 con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			*/
		}
		//System.out.println(delete);
		return delete;
	}
	
	/*public  User confirmdelete(int id){
		
		//UserAdmin customeradmin=new UserAdmin();
		//System.out.println(customeradmin.getId());
		User user=new User();
		try
		{
			ps=con.prepareStatement("select * from USER_REGISTRATION_F where ID="+id);
			rs=ps.executeQuery();
			if(rs!=null)
			{
			while(rs.next())
			{
				
				user.setUser_Id(rs.getInt("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setDob(rs.getDate("DOB"));
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
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
			
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			
		}
		return user;
	
	}
	*/
	//--------------------------CUstomer profile management----------------------------------//
	
	public User viewUrProfile(int id)
	{
		
		
		//java.sql.Date dob=new java.sql.Date(sd.parse().getTime());
		con=Dbutil.getConnection();
		//String sql="select * from USER_REGISTRATION_F where id="+id;
		try{
			ps=con.prepareStatement("select * from USER_REGISTRATION_F where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			System.out.println("into view profile");
			while(rs.next()){
				customer.setUser_Id(rs.getInt("ID"));
				customer.setPassword(rs.getString("PASSWORD"));
				customer.setName(rs.getString("NAME"));
				System.out.println(customer.getName());
				customer.setDob(rs.getDate("DOB").toString());
				System.out.println(rs.getDate("DOB").toString());
				customer.setGender(rs.getString("GENDER"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setCity(rs.getString("CITY"));
				customer.setState(rs.getString("STATE"));
				customer.setZipcode(rs.getLong("ZIPCODE"));
				customer.setPhone(rs.getLong("PHONE"));
				customer.setCategory(rs.getString("CATEGORY"));

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			 */
		}
		return customer;
	}

	//delete a customer 


	public  User confirmdelete(int id){

		//UserAdmin customeradmin=new UserAdmin();
		//System.out.println(customeradmin.getId());
		User user=new User();
		try
		{
			ps=con.prepareStatement("select * from USER_REGISTRATION_F where ID="+id);
			rs=ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{

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
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			 */
		}
		return user;

	}

	public int createUser(User customer) {
		//con = Dbutil.getConnection();
		int id=0;
		
		PreparedStatement seqPS = null;
		String addUser = "INSERT INTO USER_REGISTRATION_F"+
				" (ID, PASSWORD, NAME, DOB, GENDER, EMAIL, ADDRESS, CITY, STATE, ZIPCODE, PHONE, CATEGORY)"+
				" VALUES (SEQUENCEID.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,?)";

		try {
			SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");

			java.sql.Date Date=null;
			try {
				Date = new java.sql.Date(format.parse(customer.getDob()).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Date);

			ps=con.prepareStatement(addUser);
			ps.setString(1, customer.getPassword());
			ps.setString(2, customer.getName());
			ps.setDate(3, Date);
			ps.setString(4, customer.getGender());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getCity());
			ps.setString(8, customer.getState());
			ps.setLong(9, customer.getZipcode());
			ps.setLong(10, customer.getPhone());
			ps.setString(11, "CUSTOMER");

			if(ps.executeQuery().next())
			{
				 ps.executeUpdate();
			}
			else
			{
				return 0;
			}


			seqPS = con.prepareStatement("SELECT SEQUENCEID.CURRVAL AS ID FROM DUAL");
			rs = seqPS.executeQuery();

			if(rs.next())
			{
				id = rs.getInt("ID");
			}
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps, seqPS);
		}
		return id;
	}

	public User updateForm(int id) {

		con=Dbutil.getConnection();
		String sql="select * from USER_REGISTRATION_F where ID=?";

		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();

			while(rs.next()){
				customer.setUser_Id(rs.getInt("ID"));
				customer.setPassword(rs.getString("PASSWORD"));
				customer.setName(rs.getString("NAME"));
				customer.setDob(rs.getDate("DOB").toString());
				customer.setGender(rs.getString("GENDER"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setCity(rs.getString("CITY"));
				customer.setState(rs.getString("STATE"));
				customer.setZipcode(rs.getLong("ZIPCODE"));
				customer.setPhone(rs.getLong("PHONE"));
				customer.setCategory(rs.getString("CATEGORY"));

			}
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
		}
		return customer;
	}


	public int updateUrProfile(User customer){
		con=Dbutil.getConnection();
		int count=0;
		System.out.println("into update profilr db");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date Date=null;
		try {
			Date = new java.sql.Date(format.parse(customer.getDob()).getTime());
			System.out.println(Date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Date);
		System.out.println(customer.getDob());
		System.out.println(customer.getUser_Id());
		String sql="update USER_REGISTRATION_F set PASSWORD='"+customer.getPassword()+"',NAME='"+customer.getName()+"',DOB='"+Date+"'," +
				"GENDER='"+customer.getGender()+"',EMAIL='"+customer.getEmail()+"',ADDRESS='"+customer.getAddress()+"'," +
				"CITY='"+customer.getCity()+"',STATE='"+customer.getState()+"',ZIPCODE='"+customer.getZipcode()+"'," +
				"PHONE='"+customer.getPhone()+"' where ID="+customer.getUser_Id();
		try{
			ps=con.prepareStatement(sql);
			count=ps.executeUpdate();
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps);
		}
		return count;

	}

}
