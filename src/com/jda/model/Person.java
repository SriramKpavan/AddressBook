package com.jda.model;

import org.json.simple.JSONObject;

public class Person {

    private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String number;
	JSONObject jo;
	Person person;
   public Person() {
	    jo = new JSONObject();
   }
   
   public void toJSON(Person object) {
	   jo.put("FirstName",  object.getFirstName());
	   jo.put("LastName", object.getLastName());
	   jo.put("Address", object.getAddress());
	   jo.put("City", object.getCity());
	   jo.put("State", object.getState());
	   jo.put("Zip", object.getZip());
	   jo.put("PhoneNumber", object.getNumber());
   }
   
   public JSONObject convertJSON() {
	   return jo;
   }
   
   public void toPerson(JSONObject obj) {
	   person = new Person();
	   person.setFirstName((String) obj.get("FirstName"));
	   person.setLastName((String) obj.get("LastName"));
	   person.setAddress((String) obj.get("Address"));
	   person.setCity((String) obj.get("City"));
	   person.setState((String) obj.get("State"));
	   person.setZip((String) obj.get("ZipCode"));
	   person.setNumber((String) obj.get("PhoneNumber"));
   }

   public Person convertPerson() {
	   return person;
   }
   public void setFirstName(String firstName) {
	   this.firstName = firstName;
	   }

   public String getFirstName() {
	   return firstName;
   }

   public void setLastName(String lastName) {
	   this.lastName = lastName;
   }
   
   public String getLastName() {
	   return lastName;
   }
   
   public void setAddress(String address) {
	   this.address = address;
   }
   
   public String getAddress() {
	   return address;
   }
   
   public void setCity(String city) {
	   this.city = city;
   }
   
   public String getCity() {
	   return city;
   }
   
   public void setState(String state) {
	   this.state = state;
   }
   
   public String getState() {
	   return state;
   }
   
   public void setZip(String zip) {
	   this.zip = zip;
   }
   
   public String getZip() {
	   return zip;
   }
   
   public void setNumber(String number) {
	   this.number = number;
   }
   
   public String getNumber() {
	   return number;
   }
   
   public String toString() {
	   String x = "\n{\n" + "FirstName : " + firstName + " \n"+ "LastName : " + lastName + " \n" +"Address : " + address + " \n" +"City : " + city + " \n" + "State : " + state + " \n" + "ZipCode : " + zip + " \n" + "PhoneNumber : " + number + " \n" + "}\n";
	   return x;
   }
   
}
