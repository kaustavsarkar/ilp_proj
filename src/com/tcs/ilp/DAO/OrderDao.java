package com.tcs.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tcs.ilp.POJO.Order;
import com.tcs.ilp.Util.Dbutil;

public class OrderDao {
	
   Connection con;
   PreparedStatement ps;
   PreparedStatement ps_id;
   ResultSet rs;
   int count=0;
   
   public int addOrder(Order order, int index)
   {
	  
	   
	   String addOrderQuery="";
	   if(index==0){
		   addOrderQuery = "insert into transaction_f(orderno,tstamp,itemid,quantity,amount,outletid,id)" +
		"values(order_receipt.nextval,?,?,?,?,?,?)";
		   }
	   else{
		   System.out.println(count);
		    addOrderQuery = "insert into transaction_f(orderno,tstamp,itemid,quantity,amount,outletid,id)" +
					"values("+count+",?,?,?,?,?,?)";
		   }
	   
	   try {
			con = Dbutil.getConnection();
			ps = con.prepareStatement(addOrderQuery);
			ps.setTimestamp(1, order.getCurrentTimestamp());
			ps.setInt(2, order.getItemId());
			ps.setDouble(3, order.getQuantity());
			ps.setDouble(4, order.getAmount());
			ps.setInt(5, order.getOutletId());
			ps.setInt(6, order.getCustomerId());
			
	        ps.executeUpdate();
	        ps_id = con.prepareStatement("select order_receipt.currval as orderno from dual");
	        rs=ps_id.executeQuery();
	        
	        while(rs.next())
	        {
	        	count=rs.getInt("orderno");
	        }
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
				// TODO Auto-generated catch block
				System.out.println("Exception is occured during creating Order");
				e.printStackTrace();
			}
			finally{
				Dbutil.closeAll(con, rs, ps,ps_id);
				/*
				Dbutil.closeResultSet(rs);
				Dbutil.closeStatement(ps);
				Dbutil.closeStatement(ps_id);
				Dbutil.closeConnection(con);
				*/
				
			}
			
			return count;
   }
   
   public ArrayList<Order> viewOrder(int orderno)
   {
	   String viewOrderQuery="select * from transaction_f where orderno=?";
	   ArrayList<Order> orders=new ArrayList<Order>();
	   Order order=new Order();
	   
	   try{
		   con=Dbutil.getConnection();
		   ps=con.prepareStatement(viewOrderQuery);
		   ps.setInt(1, orderno);
		   rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			   order.setOrderNo(rs.getInt("orderno"));
			   order.setCurrentTimestamp(rs.getTimestamp("tstamp"));
			   order.setItemId(rs.getInt("itemid"));
			   order.setQuantity(rs.getDouble("quantity"));
			   order.setAmount(rs.getDouble("amount"));
			   order.setOutletId(rs.getInt("outletid"));
			   order.setCustomerId(rs.getInt("id"));
			   orders.add(order);
		   }
		   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 
				System.out.println("Exception is occured during creating customer");
				e.printStackTrace();
		   }
			finally{
				Dbutil.closeAll(con, rs, ps,ps_id);
				/*
				Dbutil.closeResultSet(rs);
				Dbutil.closeStatement(ps);
				Dbutil.closeStatement(ps_id);
				Dbutil.closeConnection(con);
				*/
				
			}
			
			return orders;
	   }
   
   public ArrayList<Order> viewOrderbycustomer(int id)
   {
	   String viewOrderQuery="select * from transaction_f where ID=? ORDER BY ORDERNO";
	   ArrayList<Order> orders=new ArrayList<Order>();
	  
	   
	   try{
		   con=Dbutil.getConnection();
		   ps=con.prepareStatement(viewOrderQuery);
		   ps.setInt(1, id);
		   rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			   Order order=new Order();
			   order.setOrderNo(rs.getInt("orderno"));
			   order.setCurrentTimestamp(rs.getTimestamp("tstamp"));
			   order.setItemId(rs.getInt("itemid"));
			   order.setQuantity(rs.getDouble("quantity"));
			   order.setAmount(rs.getDouble("amount"));
			   order.setOutletId(rs.getInt("outletid"));
			   order.setCustomerId(rs.getInt("id"));
			   orders.add(order);
		   }
		   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 
				System.out.println("Exception is occured during creating customer");
				e.printStackTrace();
		   }
			finally{
				Dbutil.closeAll(con, rs, ps,ps_id);
				/*
				Dbutil.closeResultSet(rs);
				Dbutil.closeStatement(ps);
				Dbutil.closeStatement(ps_id);
				Dbutil.closeConnection(con);
				*/
				
			}
			
			return orders;
	   }
}

   
   
   




