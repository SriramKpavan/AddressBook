package com.jda.utility;

import java.util.LinkedList;
import java.util.Scanner;

import com.jda.model.Person;

public class Utility {

	Scanner scanner;

	public Utility() {
		scanner = new Scanner(System.in);
	}

	/* This function */
	public String takeInputString() {
		String name = scanner.next();
		return name;
	}

	public int takeInputInteger() {
		int n = scanner.nextInt();
		return n;
	}

	public double takeInputDouble() {
		double n = scanner.nextDouble();
		return n;
	}
	
	public LinkedList<Person> sort(String[] array, LinkedList<Person> list) {
		// TODO Auto-generated method stub
		int n = array.length;
		for(int i =0; i<n; i++) {
			for(int j=0; j<n-i-1; j++) {
				 if (array[j].compareToIgnoreCase(array[j+1])>0)
		            {
		                String temp = array[j];
		                array[j] = array[j+1];
		                array[j+1] = temp;
		                Object s = list.get(j);
		                list.add(j, list.get(j+1));
		                list.add(j+1, (Person) s);
		            }
			}
		}
		return list;
	}
}
