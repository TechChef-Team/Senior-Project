package com.senior.techend.order;


import java.util.*;

public class Menu {
 ArrayList<Meal> meal= new ArrayList<Meal>();
public Menu(){

        ///// get the meals from the database (this is just an example) /////
        /*Meal meal1 = new Meal(null,"Caesar Salad Sandwich",15,0);
        Meal meal2 = new Meal(null,"Rib-Eye Steak",76,2);
        Meal meal3 = new Meal(null,"Country Fried Chicken",45,2);
        Meal meal4 = new Meal(null,"TripleCheese Burger ",24,0);
        Meal meal5 = new Meal(null,"Onion Rings",10,1);
        Meal meal6 = new Meal(null,"Appetizer Platter",32,1);
        Meal meal7 = new Meal(null,"Chocolate Mousse",10,3);
        Meal meal8 = new Meal(null,"Banana Split",10,3);
        Meal meal9 = new Meal(null,"Chocolate Souffle",12,3);*/

        Meal meal1 = new Meal("Caesar Salad Sandwich",15,0);
        Meal meal2 = new Meal("Rib-Eye Steak",76,2);
        Meal meal3 = new Meal("Country Fried Chicken",45,2);
        Meal meal4 = new Meal("TripleCheese Burger ",24,0);
        Meal meal5 = new Meal("Onion Rings",10,1);
        Meal meal6 = new Meal("Appetizer Platter",32,1);
        Meal meal7 = new Meal("Chocolate Mousse",10,3);
        Meal meal8 = new Meal("Banana Split",10,3);
        Meal meal9 = new Meal("Chocolate Souffle",12,3);

        ArrayList<Meal> mealsForDB = new ArrayList<Meal>();
        mealsForDB.add(meal1);
        mealsForDB.add(meal2);
        mealsForDB.add(meal3);
        mealsForDB.add(meal4);
        mealsForDB.add(meal5);
        mealsForDB.add(meal6);
        mealsForDB.add(meal7);
        mealsForDB.add(meal8);
        mealsForDB.add(meal9);
        this.meal= mealsForDB;

}


public String[][] viewMenu(){
  ArrayList<Meal> tempArrayMeals = meal;
    String [][] stringMeals = new String[tempArrayMeals.size()][3];
  int StringCounter=0;
  int categoryCounter=0;
  while(!tempArrayMeals.isEmpty())
  {
	  Iterator<Meal> mealsIterator = tempArrayMeals.iterator();
	  while(mealsIterator.hasNext())
	  {
	      Meal iteratedMeal = (Meal)mealsIterator.next();
	      if(iteratedMeal.getCategory()==categoryCounter){
	    	  /////  display it on tablet /////
              stringMeals[categoryCounter][StringCounter]=iteratedMeal.getName();
	    	  tempArrayMeals.remove(iteratedMeal);
	      }
	  }
	  categoryCounter++;
  }
    return stringMeals;
}
    public ArrayList<String> getDesserts(){
        ArrayList<String> desserts = new ArrayList<String>();
        Iterator<Meal> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                Meal iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==3)
                    desserts.add(iteratedMeal.toString());
            }
        return desserts;
    }
    public ArrayList<String> getSandwiches(){
        ArrayList<String> sandwiches = new ArrayList<String>();
        Iterator<Meal> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                Meal iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==0)
                    sandwiches.add(iteratedMeal.toString());
            }
        return sandwiches;
    }
    public ArrayList<String> getMainCourses(){
        ArrayList<String> mainCourses = new ArrayList<String>();
        Iterator<Meal> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                Meal iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==1)
                    mainCourses.add(iteratedMeal.toString());
            }
        return mainCourses;
    }
    public ArrayList<String> getAppetizers(){
        ArrayList<String> appetizers = new ArrayList<String>();
        Iterator<Meal> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                Meal iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==2)
                    appetizers.add(iteratedMeal.toString());
            }
        return appetizers;
    }
public void setmeals(ArrayList<Meal> meal){this.meal=meal;}
public void addMeal(Meal newMeal){
	meal.add(newMeal);
	updateDatebase(meal);
}
public void removeMeal(Meal oldMeal){
	meal.remove(oldMeal);
	updateDatebase(meal);
}
public Meal getMeal(int index){
    return meal.get(index);
}
public void updateDatebase(ArrayList<Meal> updatedMeals){
	
}
    public ArrayList<Meal> getMenu(){

        ///// get the meals from the database (this is just an example) /////
        Meal meal1 = new Meal("Caesar Salad Sandwich",15,0);
        Meal meal2 = new Meal("Rib-Eye Steak",76,2);
        Meal meal3 = new Meal("Country Fried Chicken",45,2);
        Meal meal4 = new Meal("TripleCheese Burger ",24,0);
        Meal meal5 = new Meal("Onion Rings",10,1);
        Meal meal6 = new Meal("Appetizer Platter",32,1);
        Meal meal7 = new Meal("Chocolate Mousse",10,3);
        Meal meal8 = new Meal("Banana Split",10,3);
        Meal meal9 = new Meal("Chocolate Souffle",12,3);

        ArrayList<Meal> mealsForDB = new ArrayList<Meal>();
        mealsForDB.add(meal1);
        mealsForDB.add(meal2);
        mealsForDB.add(meal3);
        mealsForDB.add(meal4);
        mealsForDB.add(meal5);
        mealsForDB.add(meal6);
        mealsForDB.add(meal7);
        mealsForDB.add(meal8);
        mealsForDB.add(meal9);
        return mealsForDB;
    }


}

