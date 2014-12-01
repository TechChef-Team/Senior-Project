package com.senior.techchef.orders;

import java.awt.*;
import java.util.*;

public class menu {
 ArrayList<meals> meal;
public menu(){}
public void viewMenu(){
  ArrayList<meals> tempArrayMeals = meal;
  int categoryCounter=0;
  while(!tempArrayMeals.isEmpty())
  {
	  Iterator<meals> mealsIterator = tempArrayMeals.iterator();
	  while(mealsIterator.hasNext())
	  {
	      meals iteratedMeal = (meals)mealsIterator.next();
	      if(iteratedMeal.getCategory()==categoryCounter){
	    	  /////  display it on tablet /////
	    	  tempArrayMeals.remove(iteratedMeal);
	      }
	  }
	  categoryCounter++;
  }
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
public void updateDatebase(ArrayList<meals> updatedMeals){
	
}


}

