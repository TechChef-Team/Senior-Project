package com.senior.techend.user;

import com.google.appengine.repackaged.org.codehaus.jackson.map.annotate.JsonSerialize;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Entity @JsonSerialize
public class Waiter {
    @Id
    private long id = 1;
    private String name = "Waiter 1";

    public Waiter()
    {
        id = -1;  name = "None";
    }

    public Waiter(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public void notifyWaiter(int tableId){
        ///// create a notification message to the tablet/////
    }


    public void reserveTable(Date Date,int tablesId,String customerName){

    }







}
