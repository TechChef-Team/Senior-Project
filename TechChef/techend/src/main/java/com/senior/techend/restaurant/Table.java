package com.senior.techend.restaurant;

import com.google.appengine.repackaged.org.codehaus.jackson.map.annotate.JsonSerialize;
import com.senior.techend.order.Order;
import com.senior.techend.user.Employee;
import com.senior.techend.user.Waiter;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;
import java.util.Iterator;
@Entity
public class Table {
    @Id
    private long id = 1;
    @Index
    private long tableId = 1;
    @Index
    private String tableStatus;
    @Index
	private Order order = new Order();
    @Index
    private Waiter waiter = new Waiter(1,"Waiter 1");



    public Table(long tableId, String tableStatus, Order order){
        this.tableId=tableId;
        this.tableStatus=tableStatus;
        this.order=order;
        //this.waiter=waiter;
    }
    public Table(long tableId){this.tableId=tableId;}
    public void addWaiter(Waiter waiter)
    {
       this.waiter=waiter;        	
    }
    public void addOrder(Order order){
    	this.order=order;
        setTableStatus("Ordered");
    }
    public void setTableId(long tableId){
    	this.tableId = tableId;
    }
    public void setReservation(Reservation reservation){
    	//this.reservation= reservation;
    }
    public void setTableStatus(String tableStatus){
    	this.tableStatus=tableStatus;
    	//updateTableStatus();
    }
    
    public Waiter getWaiter(){
    	return waiter;
    }
    public Order getOrder(){
    	return order;
    }
    public long getTableId(){
    	return tableId;
    }
    /*
    public Reservation getReservation(){
    	return reservation;
    }*/
    public String getTableStatus(){
    	return tableStatus;
    }
    public void notifyWaiter(){
    	 this.tableStatus="Need Waiter";
    	// updateTableStatus();
    	 //waiter.notifyWaiter(this.tableId);
    }


    public String toString(){
        return "Table ID : "+this.tableId+"\n Table Status: "+this.tableStatus;
    }


    
   
    
}

    