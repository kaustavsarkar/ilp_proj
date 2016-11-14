package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.POJO.Department;
import com.tcs.ilp.Util.Constants;
import com.tcs.ilp.Util.Dbutil;



public class DepartmentDao implements Constants{
	
	
	PreparedStatement seqPS = null;

    int count=0;
	
	
    Connection con=Dbutil.getConnection();
	PreparedStatement ps=null;	
	ResultSet rs=null;
	
    // --------------------------DEPARTMENT CREATE FUNCTION----------------------------//
	
// --------------------------DEPARTMENT CREATE FUNCTION----------------------------//
	
    public int createDepartment(Department department){

		int departmentId = 0;
		PreparedStatement ps1=null;
		/*
		String createDepartmentQuery = "INSERT INTO DEPARTMENT_F (DEPARTMENTID,DEPARTMENTNAME)" +
		"VALUES (DEPARTMENTSEQUENCE.NEXTVAL,?)";
		
		String check = "SELECT * FROM DEPARTMENT_F WHERE DEPARTMENTNAME=?";*/
		
		try {
			
			ps1=con.prepareStatement(SELECTDEPARTMENTBYNAME);
			ps1.setString(1, department.getDepartmentName().toUpperCase());
			
			if(!ps1.executeQuery().next())
			{
			ps = con.prepareStatement(ADDDEPARTMENT);
			
			ps.setString(1, department.getDepartmentName().toUpperCase());
			
			ps.executeUpdate();
			}
			else
			{
				return 0;
			}
			System.out.println("\n inside create dept \n");

			seqPS = con.prepareStatement(SELECTDEPARTMENTSEQUENCE);
			rs = seqPS.executeQuery();
			
			System.out.println("\n selecting dept seq");
			if(rs.next())
			{
				departmentId = rs.getInt("DEPARTMENTID");
			}
			
			con.commit();
			
		} catch (SQLException e) {

			System.out.println("Exception has occured during creating department");
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
		return departmentId;
	}
    
    
    
// --------------------------DEPARTMENT VIEW FUNCTION----------------------------//
	
    public ArrayList<Department> viewDepartment() {
		
		ArrayList<Department> departmentList = new ArrayList<Department>();
		/*
		String viewDepartmentQuery = "SELECT * FROM DEPARTMENT_F ORDER BY DEPARTMENTID";
		*/
		try {
			
			
			ps = con.prepareStatement(VIEWDEPARTMENT);
			
			rs = ps.executeQuery();

			while(rs.next()){
							
				Department department = new Department();
				
				department.setDepartmentId(rs.getInt("DEPARTMENTID"));
				department.setDepartmentName(rs.getString("DEPARTMENTNAME"));
		
				departmentList.add(department);
			}

		} catch (SQLException e) {
			 System.out.println("Exception occured in viewDepartment() method");
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
		System.out.println("matched departments = "+departmentList.size());
		
		return departmentList;

	}
	
    
 // --------------------------DEPARTMENT UPDATE FUNCTION----------------------------//
	
    public int updateDepartment(Department department, int departmentId){

		/*
		String updateDepartmentQuery = "UPDATE DEPARTMENT_F SET DEPARTMENTNAME=? WHERE DEPARTMENTID=?";
		*/
		
		try {
			
			
			ps = con.prepareStatement(UPDATEDEPARTMENT);
			ps.setString(1, department.getDepartmentName().toUpperCase());
			ps.setInt(2, departmentId);
			
			count=ps.executeUpdate();

			con.commit();
			
		} catch (SQLException e) {
		
			System.out.println("Exception is occured during updating department");
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
	
    
    
 // --------------------------DEPARTMENT DELETE FUNCTION----------------------------//
	
    public int deleteDepartment(int departmentId)
	{
		/*String deleteDepartmentQuery="DELETE DEPARTMENT_F WHERE DEPARTMENTID=?";*/
		
		try{
			
			
			ps=con.prepareStatement(DELETEDEPARTMENT);
			ps.setInt(1,departmentId);
			
			count=ps.executeUpdate();
			
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println("Exception is occured during deleting department");
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
	
	
	// --------------------------DEPARTMENT SEARCH FUNCTION----------------------------//
  
	public Department searchDepartment(int departmentId)
   {
	   /*String searchDepartmentQuery="SELECT * FROM DEPARTMENT_F WHERE DEPARTMENTID=?";*/
	   Department department = new Department();
	   
	   try{
		   
		   
		   ps=con.prepareStatement(SELECTDEPARTMENTBYID);
		   ps.setInt(1,departmentId);
		
		   rs=ps.executeQuery();
			
			while(rs.next()){
				
				department.setDepartmentId(departmentId);
				department.setDepartmentName(rs.getString("DEPARTMENTNAME"));
				
			}
			 }catch (SQLException e) {
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
		 return department;
   }
	

}
