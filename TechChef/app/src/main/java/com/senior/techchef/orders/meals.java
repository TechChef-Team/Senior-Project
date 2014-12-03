package com.senior.techchef.orders;


import java.util.ArrayList;


public class meals {
 
	private int quantity=1;
    private ArrayList<mealItems> items = new ArrayList<mealItems>();
    private String name;
    private double price;
    private int category=0;

    
    public meals(ArrayList<mealItems> items,String name,double price,int category){
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
    public void addItem(mealItems items){
    	
    		this.items.add(items);
    }
    public void removeItem(mealItems items){
    	
    		this.items.remove(items);
    	
    }
    public void setItems(ArrayList<mealItems> items)
    {
    	this.items=items;
    }
    
    public static void updateDataBase(meals meal){
    	
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
