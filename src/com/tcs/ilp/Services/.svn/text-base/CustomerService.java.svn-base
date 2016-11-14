package com.tcs.ilp.Services;

import java.util.ArrayList;

import com.tcs.ilp.DAO.CartDao;
import com.tcs.ilp.DAO.CustomerDAO;
import com.tcs.ilp.DAO.ItemDao;
import com.tcs.ilp.DAO.OrderDao;
import com.tcs.ilp.DAO.OutletDao;
import com.tcs.ilp.POJO.Cart;
import com.tcs.ilp.POJO.Items;
import com.tcs.ilp.POJO.Order;
import com.tcs.ilp.POJO.Outlet;
import com.tcs.ilp.POJO.User;

public class CustomerService {
	
	CartDao cartdao=new CartDao();
	CustomerDAO customerdao=new CustomerDAO();
	OrderDao orderdao=new OrderDao();
	OutletDao outletdao=new OutletDao();
	 ItemDao itemdao=new ItemDao();
	public ArrayList<Items> getItemsFromDepartment(String name){
		
		System.out.println(name);
		return customerdao.getItemsFromDepartment(name);
	}
	
	public int addCartItem(Cart cart)
	{
		int count=cartdao.addCartItem(cart);
		return count;
	}
	
	public int deleteCartItem(int itemId)
	{
		int count=cartdao.deleteCart(itemId);
		return count;
	}
	
	public ArrayList<Items> viewCart(int customerId)
	{

		return cartdao.viewCart(customerId);
	}
	public Cart retreiveItem(int itemId,int Id)
	{
		return cartdao.retreiveItem(itemId,Id);
	}
	
	public Cart retreiveItembyCart(int itemId,int Id)
	{
		return cartdao.retreiveItembyCart(itemId,Id);
	}
	
	public void updateCartQuantity(int customerId,double quantity, int itemid){
		cartdao.updateCartQuantity(customerId,quantity,itemid);
	}
	

	
	public int addOrder(Order order, int index)
	{
		return orderdao.addOrder(order, index);
	}
	
	public ArrayList<Order> viewOrder(int orderno)
	{
		return orderdao.viewOrder(orderno);
	}

	public Outlet searchOutlet(int outletId)
	 {
		 return outletdao.searchOutlet(outletId);
	 }
	
	public ArrayList<String> viewOutletStates(String state)
	{
		return outletdao.viewOutletStates(state);
	}
	public ArrayList<Outlet> viewOutletStatesDistinct(String city){
		return outletdao.viewOutletStatesDistinct(city);
	}
	
	public Items searchItems(int id){
		
		 return itemdao.searchitems(id);
	}
	public int deleteCart(int id){
		return cartdao.deleteCart(id);
	}

	public int updateItemQuantity(int itemids, double quantity) {
		// TODO Auto-generated method stub
		return itemdao.updateItemQuantity(itemids,quantity);
	}
	
	public User updateForm(int Id ) {
	     
		return customerdao.updateForm(Id);
	}
	
	public int updateUrProfile(User customer ){
		
		return customerdao.updateUrProfile(customer);
	}
	
	public int deleteCustomer(int id) {

		return customerdao.deleteUser(id);
	}

	public int createCustomer(User customer) {
		return customerdao.createUser(customer);
	}
	
	public User viewUrProfile(int id){
		
		return customerdao.viewUrProfile(id);
	}

	public ArrayList<Order> viewOrderbycustomer(int customerId) {
		// TODO Auto-generated method stub
		return orderdao.viewOrderbycustomer(customerId);
	}

	
}
	
	
