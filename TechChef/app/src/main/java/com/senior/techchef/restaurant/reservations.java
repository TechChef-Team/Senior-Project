package com.senior.techchef.restaurant;

import java.util.ArrayList;
import java.util.Date;

public class reservations {

	private Date date=new Date();
	private String customerName;
	
	public reservations(Date date,String customerName){
		this.date=date;
		this.customerName=customerName;
	}
	public reservations(){
		
	}
}
