package com.senior.techchef.users;

public class employees {

 private int id;
 private String name;
 private String password;
	
 public employees(int id,String name,String password){
	 this.id = id;
	 this.name=name;
	 this.password=password;
	 updateDatabase(this);
 }
 public employees()
 {
	 
 }
 
 public int getId(){
	 return id;
 }
 public String getName(){
	 return name;
 }
 public String getPassword(){
	 return password;
 }
 
 public void setid(int id){
	 this.id=id;
 }
 public void setName(String name){
	 this.name=name;
 }
 public void setPassword(String password){
	 this.password=password;
 }
 public static void updateDatabase(employees employee){
	 
 }
}
