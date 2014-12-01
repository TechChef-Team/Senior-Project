package com.senior.techchef.users;

import com.senior.techchef.restaurant.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class waiters extends employees {

	private ArrayList<tables> table;
	
	public waiters(int id, String name, String password) {
		super(id, name, password);
		
	}
	public waiters(){}
	public void notifyWaiter(int tableId){
		///// create a notification message to the tablet/////
	}
	
	public void monitorTables(){
		Iterator<tables> tablesIterator = table.iterator();
		while(tablesIterator.hasNext())
		{
			tables iteratedTable = tablesIterator.next();
			/////// display Table on Tablet ///////
		}
	}
	public ArrayList<tables> getTables(){
		return this.table;
	}
	public void ChangeOrder(){
		
	}
	public void reserveTable(Date Date,int tablesId,String customerName){
	 
	}
	public void printRecepit(tables table){
		table.getOrder().printReceipt();
	}
	

 	
	
}
