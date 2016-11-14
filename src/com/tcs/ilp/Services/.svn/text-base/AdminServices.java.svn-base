package com.tcs.ilp.Services;

import java.util.ArrayList;

import com.tcs.ilp.POJO.Department;
import com.tcs.ilp.POJO.Outlet;
import com.tcs.ilp.POJO.User;
import com.tcs.ilp.DAO.CustomerDAO;
import com.tcs.ilp.DAO.DepartmentDao;
import com.tcs.ilp.DAO.OutletDao;

public class AdminServices {
	
	//DAO objects
	DepartmentDao departmentDao = new DepartmentDao();
    OutletDao outletDao=new OutletDao();
    CustomerDAO customerdao=new CustomerDAO();
    
//  --------------------------------OUTLET MANAGEMENT----------------------------------------  //	
	
	//OUTLET CREATE-----------------------------------------
	
	public int createOutlet(Outlet outlet)
	{
		return outletDao.createOutlet(outlet);
	}
	
	//OUTLET VIEW ALL----------------------------------
	
	public ArrayList<Outlet> viewOutlet()
	{
		return outletDao.viewOutlet();
	}
	
	//OUTLET UPDATE-----------------------------------------------
	
	public int updateOutlet(Outlet outlet, int ouletId)
	{
		return outletDao.updateOutlet(outlet, ouletId);
	}
	
	//OUTLET DELETE----------------------------------------------------
	
	public int deleteOutlet(int outletId)
	{
		return outletDao.deleteOutlet(outletId);
	}
	
	//SELECTED OUTLET DELETE----------------------------------------------------
	
		public int deleteAllOutlets(String name)
		{
			return outletDao.deleteAllOutlets(name);
		}
		
	//OUTLET SEARCH BY OUTLET ID --------------------------------------------
	
	public Outlet searchOutlet(int outletId)
	 {
		 return outletDao.searchOutlet(outletId);
	 }
//   XXX--------------------------------OUTLET MANAGEMENT----------------------------------------XXX    //

	 
//   --------------------------------Department Management--------------------------------------   //
	
	//--------------ADDING DEPARTMENT-------------------------//
	
	public int createDepartment(Department department) {
		return departmentDao.createDepartment(department);
	}

	//-----------------------SEARCH DEPARTMENT------------------//
	
	public Department searchDepartment(int departmentId) {
		return departmentDao.searchDepartment(departmentId);
	}

	//-------------------VIEW DEPARTMENT----------------------//
	
	public ArrayList<Department> viewDepartment() {
		return departmentDao.viewDepartment();
	}

	
	//-------------------------UPDATE DEPARTMENT-----------------//
	
	public int updateDepartment(Department department, int departmentId) {
		return departmentDao.updateDepartment(department, departmentId);
	}

	//---------------------DELETE DEPARTMENT------------------------//
	
	public int deleteDepartment(int departmentId) {
		return departmentDao.deleteDepartment(departmentId);
	}
	
	
	//-------------------------Customer view and Delete-----------------//
	
	//creating dao object
			
			
			//to view all customers
			public ArrayList<User> viewallDetails(){
				
				return customerdao.viewallDetails();
			}
			/*public ArrayList<CustomerAdmin> viewForm(){
				CustomerDAO customerdao=new CustomerDAO();
				return customerdao.viewForm();
			}*/
			
			//to delete a customer
			
			public int deleteCustomer(int id)
			{
				
				return customerdao.deleteUser(id);
			}
			
			public User confirmdelete(int id){
				
				return customerdao.confirmdelete(id);
			}
			
}
