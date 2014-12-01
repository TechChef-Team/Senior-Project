package com.senior.techchef.users;

import com.senior.techchef.orders.meals;
import com.senior.techchef.orders.orders;

import java.util.*;

public class ordersList {
 
	ArrayList<orders> orderList;
	public void addOrder(orders order){
		this.orderList.add(order);
		updateOrderView();
	}
	public void removeOrder(orders order){
		this.orderList.remove(order);
		updateOrderView();
	}
	public void updateOrderView(){
		  ArrayList<orders> tempArrayOrders = this.orderList;
		  int tableIdCounter=0;
		  while(!tempArrayOrders.isEmpty())
		  {
			  Iterator<orders> ordersIterator = tempArrayOrders.iterator();
			  while(ordersIterator.hasNext())
			  {
			      orders iteratedOrder = (orders)ordersIterator.next();
			      if(iteratedOrder.getTableId()==tableIdCounter){
			    	  /////  display it on tablet by tables /////
                      
			    	  ArrayList<meals> tempArrayMeals = iteratedOrder.getMeals();
			    	  int categoryCounter=0;
			    	  while(!tempArrayMeals.isEmpty())
			    	  {
			    		  Iterator<meals> mealsIterator = tempArrayMeals.iterator();
			    		  while(mealsIterator.hasNext())
			    		  {
			    		      meals iteratedMeal = (meals)mealsIterator.next();
			    		      if(iteratedMeal.getCategory()==categoryCounter){
			    		    	  /////  display it on tablet by category /////
			    		    	  tempArrayMeals.remove(iteratedMeal);
			    		      }
			    		  }
			    		  categoryCounter++;
			    	  }
			    	  
			    	  tempArrayOrders.remove(iteratedOrder);
			      }
			  }
			  tableIdCounter++;
		  }
		}
	}

