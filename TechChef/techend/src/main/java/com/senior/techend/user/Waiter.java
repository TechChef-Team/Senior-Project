package com.senior.techend.user;

import com.google.appengine.repackaged.org.codehaus.jackson.map.annotate.JsonSerialize;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Entity
public class Waiter {
    @Id
    private long id = 1;
    @Index
    private String name = "Waiter 1";

    public Waiter()
    {
        id =  1;  name = "None";
    }

    public Waiter(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public void setId()
    {

    }
    public long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void notifyWaiter(int tableId){
        ///// create a notification message to the tablet/////
    }


    public void reserveTable(Date Date,int tablesId,String customerName){

    }







}
