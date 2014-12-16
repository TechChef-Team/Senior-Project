package com.senior.techend.user;


public class Chef extends Employee {
	
	private OrdersList orderList;
	
	public Chef(int id, String name, String password) {
		super(id, name, password);	
	}

    
	
	public void viewOrders(){
	  orderList.updateOrderView();
	}
}
