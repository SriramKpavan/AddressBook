package com.jda.controller;

import com.jda.serviceimplementation.AddressBooksOperations;
import com.jda.serviceimplementation.JDBCImplementation;
import com.jda.utility.Utility;

public class AddressBookController {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Utility utility = new Utility();
		int choice;
		System.out.println("Give any number");
		choice = utility.takeInputInteger();
		if(choice == 1) {
			AddressBooksOperations bookObject = new AddressBooksOperations();
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
					break;
					
				}
			}while(choice != 0);
		}
		else {
			JDBCImplementation impl = new JDBCImplementation();
			do {
				System.out.println("Enter a number 1.Add, 2. delete, 3.edit, 4.print");
				choice = utility.takeInputInteger();
				switch(choice) {
				case 1:
					impl.add();
					break;
					
				case 2:
					impl.delete();
					break;
					
				case 3:
					impl.edit();
					break;
					
				case 4:
					impl.printAll();
					break;
					
				}
			}while(choice != 0);
		}
		
		
	}

}