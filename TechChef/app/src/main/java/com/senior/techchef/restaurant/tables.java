package com.senior.techchef.restaurant;

import android.os.Bundle;

import com.senior.techchef.orders.orders;
import com.senior.techchef.users.employees;
import com.senior.techchef.users.waiters;

import java.util.ArrayList;
import java.util.Iterator;

public class tables {

	private orders order = new orders();
	private reservations reservation = new reservations();
	private int tableId;
    private String tableStatus;
    private waiters waiter = new waiters();

    public tables(int tableId,String tableStatus,orders order){
        this.tableId=tableId;
        this.tableStatus=tableStatus;
        this.order=order;
        //this.waiter=waiter;
    }
    public tables(int tableId){this.tableId=tableId;}
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
    
    public waiters getWaiter(){
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
    public tables getTableById(int id,ArrayList<tables> table){
        tables requestedTable=null;
        tables iteratedTable;
        Iterator tableIterator = table.iterator();
        for(int x = 0;x<table.size();x++){
            if(tableIterator.hasNext()) {
                iteratedTable = (tables) tableIterator.next();
                if(iteratedTable.getTableId()==id)
                    requestedTable=iteratedTable;
            }
        }
        return requestedTable;
    }
    public String toString(){
        return "Table ID : "+this.tableId+"\n Table Status: "+this.tableStatus;
    }
    
   
    
}

    