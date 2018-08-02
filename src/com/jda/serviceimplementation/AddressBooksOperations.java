package com.jda.serviceimplementation;

import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jda.utility.Utility;

public class AddressBooksOperations {

	Utility utility = new Utility();
	AddressBook addressBook;
	String fileName;
	public void createAddressBook() throws Exception{
		System.out.println("Enter what you want to name your file");
		fileName = utility.takeInputString();
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("Persons", ja);
		PrintWriter pw = new PrintWriter("Input//" +fileName+ ".json");
		pw.write(jo.toJSONString());
		pw.flush();
		pw.close();
	}
	
	public void openAddressBook() throws Exception {
		System.out.println("Give the name of the file you want to open");
		fileName = utility.takeInputString();
		int choice;
		do {
			AddressBook book = new AddressBook();
			System.out.println("Enter a number 1.Add a person, 2.Delete a person, 3.Edit the details of a person, 4.Sort by lastnames, 5.Sort by zipcode, 6.Print all the information");
		    choice = utility.takeInputInteger();
			switch(choice) {
			case 1:
				book.add(fileName);
				break;
				
			case 2:
				book.delete(fileName);
				break;
				
			case 3:
				book.edit(fileName);
				break;
			
			case 4:
				book.sortByLastName(fileName);
				break;
				
			case 5:
				book.sortByZip(fileName);
				break;
				
			case 6:
				book.printAll(fileName);
				break;
				
			}
		}while(choice != 0);
	}
	
	public void save() throws Exception {
		addressBook = new AddressBook();
		addressBook.updateBook(AddressBook.list, fileName);
		while(!AddressBook.list.isEmpty())
			AddressBook.list.remove();
	}
	
	
}
