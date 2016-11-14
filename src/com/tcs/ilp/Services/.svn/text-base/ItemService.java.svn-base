package com.tcs.ilp.Services;

import java.util.ArrayList;

import com.tcs.ilp.DAO.ItemDao;
import com.tcs.ilp.POJO.Items;

public class ItemService {
	//creating dao object
	ItemDao itemdao=new ItemDao();

	//item search by name
	/*
	public boolean addsearchitems(String name){
		
		return itemdao.searchItem(name);
	}
	*/
	
	//delete selected item
	
		public int deleteAllItems(String name){
			
			return itemdao.deleteAllItems(name);
		}
		
	//add items
public int additems(Items items){
		
	
	return itemdao.additems(items);
	
}
//view items
public ArrayList<Items> viewitems(){
	
	
	
	return itemdao.viewitems();
}

//search items
public Items searchitems(int itemid) {
	
	
	return itemdao.searchitems(itemid);
}

//update items

public int updateitems(Items items) {
	// TODO Auto-generated method stub
	
	
	return itemdao.updateitems(items);
}

//delete items
public int deleteitems(int itemid) {
	// TODO Auto-generated method stub
	
	
	return itemdao.deleteitems(itemid);
}
	
}
