package com.senior.techchef.users;

import com.senior.techchef.orders.orders;
import com.senior.techchef.restaurant.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class waiters extends employees {

	private ArrayList<tables> table = new ArrayList<tables>();
	
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
	public void printReceipt(tables table){
		table.getOrder().printReceipt();
	}
    public void addTable(tables table){
        this.table.add(table);
    }
    public void confirmOrder(orders order){
        Iterator<tables> tablesIterator = table.iterator();
        while(tablesIterator.hasNext())
        {
            tables iteratedTable = tablesIterator.next();
            if(iteratedTable.getTableId()==order.getTableId()){
                iteratedTable.setTableStatus("Order Confirmed");
                iteratedTable.updateTableStatus();
            }
            /////// display Table on Tablet ///////
        }
    }
	

 	
	
}
