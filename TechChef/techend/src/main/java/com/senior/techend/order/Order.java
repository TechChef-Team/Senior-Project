package com.senior.techend.order;

import com.senior.techend.restaurant.Table;

import java.util.ArrayList;
import java.util.Iterator;

public class Order {
    private ArrayList<Meal> meal = new ArrayList<Meal>();
    private int tableId = 0;

    public void addMeal(Meal meal) {
        this.meal.add(meal);

    }

    public void removeMeal(Meal meal) {
        this.meal.remove(meal);
    }

    public void modifyQuantity(Meal oldMeal, int quantity) {
        Iterator<Meal> mealIterator = meal.iterator();
        while(mealIterator.hasNext())
        {
            Meal iteratedMeal = mealIterator.next();
            if(oldMeal==iteratedMeal)
                iteratedMeal.modifyQuantity(quantity);
        }

    }

    public void printReceipt() {

    }

    public Table getTableById(int id,ArrayList<Table> table){
        Table requestedTable=null;
        Table iteratedTable;
        Iterator tableIterator = table.iterator();
        for(int x = 0;x<table.size();x++){
            if(tableIterator.hasNext()) {
                iteratedTable = (Table) tableIterator.next();
                if(iteratedTable.getTableId()==id)
                    requestedTable=iteratedTable;
            }
        }
        return requestedTable;
    }

    public ArrayList<String> viewOrder() {

        ArrayList<String> orderMeals = new ArrayList<String>();
        Iterator<Meal> mealsIterator = meal.iterator();
        for (int x = 0; x < meal.size(); x++)
            if (mealsIterator.hasNext()) {
                Meal iteratedMeal = mealsIterator.next();
                orderMeals.add(iteratedMeal.getName());
            }
        return orderMeals;

    }

    // public void confirmOrder() {}

    public void setTableId(int newTableId) {
        this.tableId = newTableId;
        updateDataBase();
    }

    public int getTableId() {
        return (this.tableId);
    }

    public ArrayList<Meal> getMeals() {
        return (this.meal);
    }

    public void viewMeals(ArrayList<Meal> meal) {

    }
    public void updateDataBase(){

    }



}