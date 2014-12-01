package com.senior.techchef.restaurant;

import com.senior.techchef.orders.orders;
import com.senior.techchef.users.employees;
import com.senior.techchef.users.waiters;

public class tables {

	private orders order = new orders();
	private reservations reservation = new reservations();
	private int tableId;
    private String tableStatus;
    private waiters waiter = new waiters();
    
    public void addWaiter(waiters waiter)
    {
       this.waiter=waiter;        	
    }
    public void addOrder(orders order){
    	this.order=order;
    }
    public void setTableId(int tableId){
    	this.tableId = tableId;
    }
    public void setReservation(reservations reservation){
    	this.reservation= reservation;
    }
    public void setTableStatus(String tableStatus){
    	this.tableStatus=tableStatus;
    	updateTableStatus();
    }
    
    public employees getWaiter(){
    	return waiter;
    }
    public orders getOrder(){
    	return order;
    }
    public int getTableId(){
    	return tableId;
    }
    public reservations getReservation(){
    	return reservation;
    }
    public String getTableStatus(){
    	return tableStatus;
    }
    public void notifyWaiter(){
    	 this.tableStatus="Need Waiter";
    	 updateTableStatus();
    	 waiter.notifyWaiter(this.tableId);
    }
    public void updateTableStatus(){
    	///// update on tablet /////
    }
    
    
   
    
}

    