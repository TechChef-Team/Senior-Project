package com.senior.techend.user;

public class Employee {

 private long id;
 private String name;
 private String password;
	
 public Employee(int id, String name, String password){
	 this.id = id;
	 this.name=name;
	 this.password=password;
	 updateDatabase(this);
 }
 public Employee()
 {
	 
 }
 
 public long getId(){
	 return id;
 }
 public String getName(){
	 return name;
 }
 public String getPassword(){
	 return password;
 }
 
 public void setid(long id){
	 this.id=id;
 }
 public void setName(String name){
	 this.name=name;
 }
 public void setPassword(String password){
	 this.password=password;
 }
 public static void updateDatabase(Employee employee){
	 
 }
}
