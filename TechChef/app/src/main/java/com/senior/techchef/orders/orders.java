package com.senior.techchef.orders;

import java.util.ArrayList;
import java.util.LinkedList;

public class orders {
	private ArrayList<meals> meals;
	private int tableId=0; 
	
 public void addMeal(meals meal)
 {
	this.meals.add(meal); 
 }
 public void removeMeal(meals meal){
	 meals.remove(meal);
 }
 public void modifyQuantity(meals meal,int quantity){
	 meal.modifyQuantity(quantity);
 }
 public void printReceipt(){
	 
 }
 public void viewOrder(){
	 
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
	 return (this.meals);
 }
}
