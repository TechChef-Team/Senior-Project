package com.senior.techchef.users;

import java.util.ArrayList;


public class chefs extends employees {
	
	private ordersList orderList; 
	
	public chefs(int id, String name, String password) {
		super(id, name, password);	
	}

    
	
	public void viewOrders(){
	  orderList.updateOrderView();
	}
}
