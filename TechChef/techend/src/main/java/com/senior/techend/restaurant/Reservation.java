package com.senior.techend.restaurant;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {

	private Date date=new Date();
	private String customerName;
	
	public Reservation(Date date, String customerName){
		this.date=date;
		this.customerName=customerName;
	}
	public Reservation(){
		
	}
}
