package com.senior.techchef.orders;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class orders {
	private ArrayList<meals> meal = new ArrayList<meals>();
	private int tableId=0; 
	
 public void addMeal(meals meal)
 {
	this.meal.add(meal);
 }
 public void removeMeal(meals meal){
	 this.meal.remove(meal);
 }
 public void modifyQuantity(meals meal,int quantity){
	 meal.modifyQuantity(quantity);
 }
 public void printReceipt(){
	 
 }
 public ArrayList<String> viewOrder(){

         ArrayList<String> orderMeals = new ArrayList<String>();
         Iterator<meals> mealsIterator = meal.iterator();
         for(int x =0;x<meal.size();x++)
             if(mealsIterator.hasNext())
             {
                 meals iteratedMeal = mealsIterator.next();
                 orderMeals.add(iteratedMeal.getName());
             }
         return orderMeals;

 }
 public void confirmOrder(){
	 
 }
 public void setTableId(int newTableId){
	 this.tableId=newTableId;
 }
 public int getTableId(){
	 return(this.tableId);
 }
 public ArrayList<meals> getMeals(){
	 return (this.meal);
 }
 public void viewMeals(ArrayList<meals> meal){

 }
}
