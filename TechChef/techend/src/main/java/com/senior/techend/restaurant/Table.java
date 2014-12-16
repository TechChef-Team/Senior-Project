package com.senior.techend.restaurant;

import com.senior.techend.order.Order;
import com.senior.techend.user.Employee;
import com.senior.techend.user.Waiter;

import java.util.ArrayList;
import java.util.Iterator;

public class Table {

	private Order order = new Order();
	private Reservation reservation = new Reservation();
	private int tableId;
    private String tableStatus;
    private Waiter waiter = new Waiter();

    public Table(int tableId, String tableStatus, Order order){
        this.tableId=tableId;
        this.tableStatus=tableStatus;
        this.order=order;
        //this.waiter=waiter;
    }
    public Table(int tableId){this.tableId=tableId;}
    public void addWaiter(Waiter waiter)
    {
       this.waiter=waiter;        	
    }
    public void addOrder(Order order){
    	this.order=order;
    }
    public void setTableId(int tableId){
    	this.tableId = tableId;
    }
    public void setReservation(Reservation reservation){
    	this.reservation= reservation;
    }
    public void setTableStatus(String tableStatus){
    	this.tableStatus=tableStatus;
    	updateTableStatus();
    }
    
    public Waiter getWaiter(){
    	return waiter;
    }
    public Order getOrder(){
    	return order;
    }
    public int getTableId(){
    	return tableId;
    }
    public Reservation getReservation(){
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
    public Table getTableById(int id,ArrayList<Table> table){
        Table requestedTable=null;
        Table iteratedTable;
        Iterator tableIterator = table.iterator();
        for(int x = 0;x<table.size();x++){
            if(tableIterator.hasNext()) {
                iteratedTable = (Table) tableIterator.next();
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

    