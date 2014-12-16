package com.senior.techend.user;

import com.senior.techend.order.Order;
import com.senior.techend.restaurant.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class Waiter extends Employee {

	private ArrayList<Table> table = new ArrayList<Table>();
	
	public Waiter(int id, String name, String password) {
		super(id, name, password);
	}
	public Waiter(){}
	public void notifyWaiter(int tableId){
		///// create a notification message to the tablet/////
	}
	
	public void monitorTables(){
		Iterator<Table> tablesIterator = table.iterator();
		while(tablesIterator.hasNext())
		{
            Table iteratedTable = tablesIterator.next();
			/////// display Table on Tablet ///////
		}
	}
	public ArrayList<Table> getTables(){
		return this.table;
	}
	public void ChangeOrder(){
		
	}
	public void reserveTable(Date Date,int tablesId,String customerName){
	 
	}
	public void printReceipt(Table table){
		table.getOrder().printReceipt();
	}
    public void addTable(Table table){
        this.table.add(table);
    }
    public void confirmOrder(Order order){
        Iterator<Table> tablesIterator = table.iterator();
        while(tablesIterator.hasNext())
        {
            Table iteratedTable = tablesIterator.next();
            if(iteratedTable.getTableId()==order.getTableId()){
                iteratedTable.setTableStatus("Order Confirmed");
                iteratedTable.updateTableStatus();
            }
            /////// display Table on Tablet ///////
        }
    }
	

 	
	
}
