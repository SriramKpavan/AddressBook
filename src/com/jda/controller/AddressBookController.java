package com.jda.controller;

import com.jda.serviceimplementation.AddressBook;
import com.jda.serviceimplementation.AddressBooksOperations;
import com.jda.utility.Utility;

public class AddressBookController {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		AddressBooksOperations bookObject = new AddressBooksOperations();
		Utility utility = new Utility();
		int choice;
		do {
			System.out.println("Enter a number 1.Create a new Address Book, 2.Open and Edit the open AddressBook, 3.Save the changes done, 0.Quit");
			choice = utility.takeInputInteger();
			switch(choice) {
			case 1:
				bookObject.createAddressBook();
				break;
				
			case 2:
				bookObject.openAddressBook();
				break;		
				
			case 3:
				bookObject.save();
				
			}
		}while(choice != 0);
		
	}

}