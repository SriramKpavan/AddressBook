package com.jda.serviceimplementation;

import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.jda.model.Person;
import com.jda.utility.Utility;

public class AddressBook {

	Utility utility = new Utility();
	static LinkedList<Person> list = new LinkedList<Person>();
	Person person;
	
	public LinkedList<Person> readFile() throws Exception{
		JSONParser parser = new JSONParser();
		person = new Person();
		Object obj = parser.parse(new FileReader("Input//AddressBook.json"));
		JSONObject jo = (JSONObject)obj ;
		JSONArray ja = (JSONArray) jo.get("Persons");
		for(int i=0; i<ja.size(); i++){
			person.toPerson((JSONObject) ja.get(i));
			System.out.println(person.convertPerson());
			list.add(person.convertPerson());	
		}
		return list;	
	}
	
	public void add() throws Exception {
		list = readFile();
		person = new Person();
		System.out.println("Give the name of the person you want to add");
		String firstname = utility.takeInputString();
		person.setFirstName(firstname);
		System.out.println("Give the last name of the person");
		String lastname = utility.takeInputString();
		person.setLastName(lastname);
		System.out.println("Give the address");
		String address = utility.takeInputString();
		person.setAddress(address);
		System.out.println("Give the city of the person");
		String city = utility.takeInputString();
		person.setCity(city);
		System.out.println("Give the state of the person");
		String state = utility.takeInputString();
		person.setState(state);
		System.out.println("Give the zip of the person");
		String zip = utility.takeInputString();
		person.setZip(zip);
		System.out.println("Give the number of the person");
		String num = utility.takeInputString();
		person.setNumber(num);
		list.add(person);
		updateBook(list);
	}
	
	private void updateBook(LinkedList<Person> list) throws Exception {
		// TODO Auto-generated method stub
		JSONObject jo = new JSONObject();
		LinkedList<JSONObject> finalList = new LinkedList<JSONObject>();
		while(!(list.isEmpty())) {
			person.toJSON(list.remove());
			finalList.add(person.convertJSON());
		}
		jo.put("Persons", finalList);
		PrintWriter pw = new PrintWriter("Input//AddressBook.json");
		pw.write(jo.toJSONString());
		pw.flush();
		pw.close();
	}

	public void delete() throws Exception {
		list = readFile();
		System.out.println("Give the name of the person you want to delete");
		String name = utility.takeInputString();
		for(int i =0; i<list.size(); i++) {
			person = list.get(i);
			if(person.getFirstName().equals(name))
				list.remove(person);
			break;
		}
		
		updateBook(list);
	}
	
	public void edit() throws Exception {
		list = readFile();
		System.out.println("Give the name of the person whose details you want to edit");
		String name = utility.takeInputString();
		for(int i=0; i<list.size(); i++) {
			person = list.get(i);
			if(person.getFirstName().compareTo(name) == 0) {
				list.remove(person);
				person.setFirstName(name);
				System.out.println("Give the last name of the person");
				String lastname = utility.takeInputString();
				person.setLastName(lastname);
				System.out.println("Give the address");
				String address = utility.takeInputString();
				person.setAddress(address);
				System.out.println("Give the city of the person");
				String city = utility.takeInputString();
				person.setCity(city);
				System.out.println("Give the state of the person");
				String state = utility.takeInputString();
				person.setState(state);
				System.out.println("Give the zip of the person");
				String zip = utility.takeInputString();
				person.setZip(zip);
				System.out.println("Give the number of the person");
				String num = utility.takeInputString();
				person.setNumber(num);
				list.add(person);
				break;
			}
		}
		
		updateBook(list);
	}
	
	public void sortByLastName() throws Exception {
		list = readFile();
		int n = list.size();
		String[] lastNames = new String[n];
		for(int i=0; i<n; i++) 
			lastNames[i] = list.get(i).getLastName();
		list = utility.sort(lastNames, list);
		updateBook(list);
	}
	
	public void sortByZip() throws Exception {
		list = readFile();
		int n = list.size();
		String[] lastNames = new String[n];
		for(int i=0; i<n; i++) 
			lastNames[i] = list.get(i).getZip();
		list = utility.sort(lastNames, list);
		updateBook(list);
	}
	
	public void printAll() throws Exception {
		list = readFile();
		//System.out.println("blah");
		while(list.isEmpty())
			System.out.println(list.remove());
	}
}
