package com.jda.serviceimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jda.model.Database;
import com.jda.utility.Utility;

public class JDBCImplementation {

	static Utility utility;
	static {
		utility = new Utility();
	}
	Database data = new Database();
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	public void add() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedback?"
                            + "user=sqluser&password=sqluserpw");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("insert into addressbook.addressdetails values ( ?, ?, ?, ?, ?)");
			
		System.out.println("'addressbook' database exists, inserting values in addressBook");
		System.out.println("Enter First name : ");
		String firstName = utility.takeInputString();
	    System.out.println("Enter Last name : ");
		String lastName = utility.takeInputString();
		System.out.print("Enter mob no : ");
		long mobno = utility.takeInputLong();
		utility.emptyInput();
		System.out.println("Enter city : ");
		String city = utility.takeInputString();
		System.out.println("Enter state : ");
		String state = utility.takeInputString();
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setLong(3, mobno);
		preparedStatement.setString(4, city);
		preparedStatement.setString(5, state);
		preparedStatement.addBatch();
		preparedStatement.executeBatch();
		System.out.println("Record inserted.");
		}
		
		catch (Exception e) {
            throw e;
        } finally {
            data.close();
        }
	}
	
	public void delete() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         // Setup the connection with the DB
	         connect = DriverManager
	                 .getConnection("jdbc:mysql://localhost/addressbook?"
	                         + "user=sqluser&password=sqluserpw");

	         // Statements allow to issue SQL queries to the database
	         System.out.println("Give the name of the person you want to delete");
	         String option = utility.takeInputString();
	         String query = "DELETE FROM addressbook.addressdetails WHERE FIRSTNAME = '" + option + "'";
	 		 statement = connect.createStatement();
	 		statement.executeUpdate(query);
		}
		
		catch (Exception e) {
            throw e;
        } finally {
            data.close();
        }
	}
	
	public void edit() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         // Setup the connection with the DB
	         connect = DriverManager
	                 .getConnection("jdbc:mysql://localhost/feedback?"
	                         + "user=sqluser&password=sqluserpw");

	         // Statements allow to issue SQL queries to the database
	         System.out.println("Give the name of the person you want to edit");
	         String name = utility.takeInputString();
	         System.out.println("Give the attribute you want to change");
	 		 String n = utility.takeInputString();
	 		 System.out.println("Give the value you want to change");
	 		 String input = utility.takeInputString();
	         String query = "UPDATE addressbook.addressdetails\r\n" + "SET "+ n + "= '" + input + "'\r\n" + "WHERE FIRSTNAME = '" + name + "';";
	 		 statement = connect.createStatement();
	 		 statement.executeUpdate(query);
		}
		
		catch (Exception e) {
            throw e;
        } finally {
            data.close();
        }
	}
	
	public void printAll() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/feedback?"
                        + "user=sqluser&password=sqluserpw");
		String query = "SELECT * FROM addressbook.addressdetails";
		statement = connect.createStatement();
		resultSet = statement.executeQuery(query);
		data.writeResultSet(resultSet);
		data.close();
	}
}
