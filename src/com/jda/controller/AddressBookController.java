package com.jda.controller;

import com.jda.serviceimplementation.AddressBook;
import com.jda.utility.Utility;

public class AddressBookController {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		AddressBook book = new AddressBook();
		Utility utility = new Utility();
		int choice;
		do {
			System.out.println("Enter a number 1.Add a person, 2.Delete a person, 3.Edit the details of a person, 4.Sort by lastnames, 5.Sort by zipcode, 6.Print all the information");
		    choice = utility.takeInputInteger();
			switch(choice) {
			case 1:
				book.add();
				break;
				
			case 2:
				book.delete();
				break;
				
			case 3:
				book.edit();
				break;
			
			case 4:
				book.sortByLastName();
				break;
				
			case 5:
				book.sortByZip();
				break;
				
			case 6:
				book.printAll();
				break;
				
			}
		}while(choice != 0);
	}

}