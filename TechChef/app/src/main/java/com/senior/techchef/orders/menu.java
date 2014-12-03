package com.senior.techchef.orders;


import java.util.*;

public class menu {
 ArrayList<meals> meal= new ArrayList<meals>();
public menu(){

        ///// get the meals from the database (this is just an example) /////
        meals meal1 = new meals(null,"Caesar Salad Sandwich",15,0);
        meals meal2 = new meals(null,"Rib-Eye Steak",76,2);
        meals meal3 = new meals(null,"Country Fried Chicken",45,2);
        meals meal4 = new meals(null,"TripleCheese Burger ",24,0);
        meals meal5 = new meals(null,"Onion Rings",10,1);
        meals meal6 = new meals(null,"Appetizer Platter",32,1);
        meals meal7 = new meals(null,"Chocolate Mousse",10,3);
        meals meal8 = new meals(null,"Banana Split",10,3);
        meals meal9 = new meals(null,"Chocolate Souffle",12,3);

        ArrayList<meals> mealsForDB = new ArrayList<meals>();
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
  ArrayList<meals> tempArrayMeals = meal;
    String [][] stringMeals = new String[tempArrayMeals.size()][3];
  int StringCounter=0;
  int categoryCounter=0;
  while(!tempArrayMeals.isEmpty())
  {
	  Iterator<meals> mealsIterator = tempArrayMeals.iterator();
	  while(mealsIterator.hasNext())
	  {
	      meals iteratedMeal = (meals)mealsIterator.next();
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
        Iterator<meals> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                meals iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==3)
                    desserts.add(iteratedMeal.toString());
            }
        return desserts;
    }
    public ArrayList<String> getSandwiches(){
        ArrayList<String> sandwiches = new ArrayList<String>();
        Iterator<meals> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                meals iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==0)
                    sandwiches.add(iteratedMeal.toString());
            }
        return sandwiches;
    }
    public ArrayList<String> getMainCourses(){
        ArrayList<String> mainCourses = new ArrayList<String>();
        Iterator<meals> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                meals iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==1)
                    mainCourses.add(iteratedMeal.toString());
            }
        return mainCourses;
    }
    public ArrayList<String> getAppetizers(){
        ArrayList<String> appetizers = new ArrayList<String>();
        Iterator<meals> mealsIterator = meal.iterator();
        for(int x =0;x<meal.size();x++)
            if(mealsIterator.hasNext())
            {
                meals iteratedMeal = mealsIterator.next();
                if(iteratedMeal.getCategory()==2)
                    appetizers.add(iteratedMeal.toString());
            }
        return appetizers;
    }
public void setmeals(ArrayList<meals> meal){this.meal=meal;}
public void addMeal(meals newMeal){
	meal.add(newMeal);
	updateDatebase(meal);
}
public void removeMeal(meals oldMeal){
	meal.remove(oldMeal);
	updateDatebase(meal);
}
public meals getMeal(int index){
    return meal.get(index);
}
public void updateDatebase(ArrayList<meals> updatedMeals){
	
}
    public ArrayList<meals> getMenu(){

        ///// get the meals from the database (this is just an example) /////
        meals meal1 = new meals(null,"Caesar Salad Sandwich",15,0);
        meals meal2 = new meals(null,"Rib-Eye Steak",76,2);
        meals meal3 = new meals(null,"Country Fried Chicken",45,2);
        meals meal4 = new meals(null,"TripleCheese Burger ",24,0);
        meals meal5 = new meals(null,"Onion Rings",10,1);
        meals meal6 = new meals(null,"Appetizer Platter",32,1);
        meals meal7 = new meals(null,"Chocolate Mousse",10,3);
        meals meal8 = new meals(null,"Banana Split",10,3);
        meals meal9 = new meals(null,"Chocolate Souffle",12,3);

        ArrayList<meals> mealsForDB = new ArrayList<meals>();
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

