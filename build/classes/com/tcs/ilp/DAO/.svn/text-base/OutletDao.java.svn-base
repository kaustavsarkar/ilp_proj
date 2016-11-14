package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.POJO.Outlet;
import com.tcs.ilp.Util.Constants;
import com.tcs.ilp.Util.Dbutil;

public class OutletDao implements Constants{
	int count=0;
	
    Connection con=null;
	PreparedStatement ps=null;	
	ResultSet rs=null;
	
	// OUTLET CREATE FUNCTION--------------------------------------------------------------
	public int createOutlet(Outlet outlet){
		con=Dbutil.getConnection();
		PreparedStatement seqPS = null;
		
		int outletId = 0;
		/*String createOutletQuery = "insert into OUTLET_F (outletid,address,state,city,zipcode)" +
		"values(outletseq.nextval,?,?,?,?)";*/
		try {
			
			ps = con.prepareStatement(ADDOUTLET);
			ps.setString(1, outlet.getAddress());
			ps.setString(2, outlet.getState());
			ps.setString(3, outlet.getCity());
			ps.setDouble(4, outlet.getZipCode());
			
			ps.executeUpdate();

			seqPS = con.prepareStatement(SELECTOUTLETSEQUENCE);
			rs = seqPS.executeQuery();
			if(rs.next()){
				outletId = rs.getInt("outletid");
			}
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is occured during creating OUTLET");
			e.printStackTrace();
		}
		finally{
			Dbutil.closeAll(con, rs, ps,seqPS);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeStatement(seqPS);
			Dbutil.closeConnection(con);
			*/
		}
		return outletId;
	}

	//OUTLET VIEW FUNCTION-------------------------------------------------------------------------
	public ArrayList<Outlet> viewOutlet() {
		// TODO Auto-generated method stub
		con=Dbutil.getConnection();
		ArrayList<Outlet> outletList = new ArrayList<Outlet>();
		/*String viewCustomerSQL = "select * from OUTLET_F order by outletid";*/
		try {
			
			ps = con.prepareStatement(VIEWOUTLETBYID);
			rs = ps.executeQuery();

			while(rs.next()){
							
				Outlet outlet = new Outlet();
				outlet.setOutletId(rs.getInt("OutletID"));
				outlet.setAddress(rs.getString("address"));
				outlet.setState(rs.getString("state"));
				outlet.setCity(rs.getString("city"));
				outlet.setZipCode(rs.getLong("zipcode"));
		
				outletList.add(outlet);
			}
			

		} catch (SQLException e) {
			System.out.println("Exception is occured during vewing outlet");
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
		System.out.println("matched outlets = "+outletList.size());
		return outletList;

	}
	

	//OUTLET UPDATE ---------------------------------------------------------------------------------
	public int updateOutlet(Outlet outlet, int outletId){

		/*
		String createOutletQuery = "update OUTLET_F set address=?,state=?,city=?,zipcode=? where outletid=?";
		*/
		con=Dbutil.getConnection();
		
		try {
			
			ps = con.prepareStatement(UPDATEOUTLET);
			ps.setString(1, outlet.getAddress());
			ps.setString(2, outlet.getState());
			ps.setString(3, outlet.getCity());
			ps.setDouble(4, outlet.getZipCode());
			ps.setInt(5, outletId);
			
			count=ps.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is occured during updating outlet");
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
		return count;
	}
	
	//DELETE OUTLET ---------------------------------------------------------------------------------
	public int deleteOutlet(int outletId)
	{
		//String deleteOutletQuery="delete OUTLET_F where outletid=?";
		con=Dbutil.getConnection();
		
		try{
		
			ps=con.prepareStatement(DELETEOUTLET);
			ps.setInt(1,outletId);
			count=ps.executeUpdate();
			
			con.commit();
		}catch(Exception e)
		{
			System.out.println("Exception is occured during deleting outlet");
			e.printStackTrace();
		}		finally{
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			*/
		}
		return count;

	}

	//delete selected OUTLET--------------------------------------------------------------------------
	
	public int deleteAllOutlets(String name){
		//con=Dbutil.getConnection();
		
		String query3="DELETE OUTLET_F WHERE outletid IN ("+name+")";
		con=Dbutil.getConnection();
		
		try{
			ps=con.prepareStatement(query3);
			//ps.setString(1,name);
			
			count=ps.executeUpdate();
			con.commit();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	

		finally{
			//closing the statements and connection 
			Dbutil.closeAll(con, rs, ps);
			/*
			Dbutil.closeResultSet(rs);
			Dbutil.closeStatement(ps);
			Dbutil.closeConnection(con);
			*/
		}
		
		return count;
	}
	
	//SEARCH OUTLET --------------------------------------------------------------------------
   public Outlet searchOutlet(int outletId)
   {
	  /* String searchOutletQuery="select * from OUTLET_F where outletid=?";*/
	   con=Dbutil.getConnection();
	   Outlet outlet = new Outlet();
	   
	   try{
		   
			ps=con.prepareStatement(SELECTOUTLETBYID);
			ps.setInt(1,outletId);
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				outlet.setOutletId(outletId);
				outlet.setAddress(rs.getString("address"));
				outlet.setCity(rs.getString("city"));
				outlet.setState(rs.getString("state"));

				outlet.setZipCode(rs.getLong("zipcode"));
				System.out.println(outlet.getCity()+":state:"+outlet.getState());
				con.commit();
			}
			 }catch (SQLException e) {
				 System.out.println("Exception is occured during searching outlet");
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
		 return outlet;
   }


   
 //SEARCH OUTLET cities by state--------------------------------------------------------------------------
   
   public ArrayList<String> viewOutletStates(String state)
   {
	   con=Dbutil.getConnection();
	   String searchOutletQuery="select city from OUTLET_F where state=?";
	ArrayList<String> cities=new ArrayList<String>();
	   
	   try{
		   
			ps=con.prepareStatement(searchOutletQuery);
			ps.setString(1,state);
			rs=ps.executeQuery();
			cities.add(0, "--Select--");
			while(rs.next()){
				cities.add(rs.getString("city"));
		
				con.commit();
			}
			 }catch (SQLException e) {
				 System.out.println("Exception is occured during searching outlet");
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
		 return cities;
   }
   
   public ArrayList<Outlet> viewOutletStatesDistinct(String city)
   {
	   String searchOutletQuery="select * from OUTLET_F  WHERE CITY=?";
	   Outlet outlet = new Outlet();
	   con=Dbutil.getConnection();
	   ArrayList<Outlet> outlets=new ArrayList<Outlet>();
	   
	   try{
		   
			ps=con.prepareStatement(searchOutletQuery);
			ps.setString(1,city);
			rs=ps.executeQuery();
			
			while(rs.next()){
				outlet.setOutletId(rs.getInt("OUTLETID"));
				outlet.setAddress(rs.getString("address"));
				outlet.setCity(rs.getString("city"));
				outlet.setState(rs.getString("state"));
				outlet.setZipCode(rs.getLong("zipcode"));
				outlets.add(outlet);
		
				con.commit();
			}
			 }catch (SQLException e) {
				 System.out.println("Exception is occured during searching outlet");
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
		 return outlets;
   }
   
}
