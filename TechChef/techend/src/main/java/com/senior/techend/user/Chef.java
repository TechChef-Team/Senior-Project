package com.senior.techend.user;

//public class Chef extends Employee {
public class Chef {

    private long id = 1;
    private String name = "Chef 1";
	private OrdersList orderList;

    public Chef (){
        id = 1;
        name = "Chef 1";
    }
	
	/*public Chef(int id, String name, String password) {
		super(id, name, password);	
	}*/

    
	
	public void viewOrders(){
	  orderList.updateOrderView();
	}
}
