package com.senior.techend.order;


import java.util.ArrayList;


public class Meal {
 
	private int quantity=1;
    private ArrayList<MealItem> items = new ArrayList<MealItem>();
    private String name;
    private double price;
    private int category=0;

    
    public Meal(ArrayList<MealItem> items, String name, double price, int category){
    	this.quantity=1;
    	this.items=items;
    	this.name=name;
    	this.price=price;
    	this.category=category;
    	updateDataBase(this);
    }
    
    public void modifyQuantity(int quantity){
    	this.quantity=quantity;
    }
    public void modifyPrice(double price){
    	this.price=price;
    }
    public void modifyName(String name){
    	this.name=name;
    }
    public void changeCategory(int category){
    	this.category=category;
    }
    public int getCategory(){
    	return(this.category);
    }
    public void addItem(MealItem items){
    	
    		this.items.add(items);
    }
    public void removeItem(MealItem items){
    	
    		this.items.remove(items);
    	
    }
    public void setItems(ArrayList<MealItem> items)
    {
    	this.items=items;
    }
    
    public static void updateDataBase(Meal meal){
    	
    }
    public void viewMealImage(){
    	
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String toString(){
        return this.getName()+"  "+getPrice()+"$";
    }
}
