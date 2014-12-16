package com.senior.techend.user;

import com.senior.techend.order.Meal;
import com.senior.techend.order.Order;

import java.util.*;

public class OrdersList {
 
	ArrayList<Order> orderList = new ArrayList<Order>();
	public void addOrder(Order order){
		this.orderList.add(order);
		//updateOrderView();
	}
	public void removeOrder(Order order){
		this.orderList.remove(order);
		//updateOrderView();
	}
    public ArrayList<Order> getOrderList(){
        return this.orderList;
    }
	public void updateOrderView(){
		  ArrayList<Order> tempArrayOrders = this.orderList;
		  int tableIdCounter=0;
		  while(!tempArrayOrders.isEmpty())
		  {
			  Iterator<Order> ordersIterator = tempArrayOrders.iterator();
			  while(ordersIterator.hasNext())
			  {
                  Order iteratedOrder = (Order)ordersIterator.next();
			      if(iteratedOrder.getTableId()==tableIdCounter){
			    	  /////  display it on tablet by tables /////
                      
			    	  ArrayList<Meal> tempArrayMeals = iteratedOrder.getMeals();
			    	  int categoryCounter=0;
			    	  while(!tempArrayMeals.isEmpty())
			    	  {
			    		  Iterator<Meal> mealsIterator = tempArrayMeals.iterator();
			    		  while(mealsIterator.hasNext())
			    		  {
			    		      Meal iteratedMeal = (Meal)mealsIterator.next();
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
    public ArrayList<String> getOrderDetails(int index){
        return orderList.get(index).viewOrder();
    }

	}

