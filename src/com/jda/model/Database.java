package com.jda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jda.utility.Utility;

public class Database {

	static Utility utility;
	static {
		utility = new Utility();
	}
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	public void addressBookJDBC() throws Exception {
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
		System.out.println("Enter number of entries.");
		Integer n = utility.takeInputInteger();
		//utility.emptyInput();
		for(int i=0;i<n;i++) {
			System.out.println(i+1);
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
		System.out.println("All records inserted.");	
	}
		catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void writeResultSet(ResultSet resultSet) throws SQLException {
	        // ResultSet is initially before the first data set
	        while (resultSet.next()) {
	            // It is possible to get the columns via name
	            // also possible to get the columns via the column number
	            // which starts at 1
	            // e.g. resultSet.getSTring(2);
	            String firstname = resultSet.getString("FIRSTNAME");
	            String lastname = resultSet.getString("LASTNAME");
	            long mobno = resultSet.getLong("MOBNUMBER");
	            String city = resultSet.getString("CITY");
	            String state = resultSet.getString("STATE");
	            System.out.println("FirstName: " + firstname);
	            System.out.println("LastName: " + lastname);
	            System.out.println("MobNo : : " + mobno);
	            System.out.println("City: " + city);
	            System.out.println("State : " + state);
	        }
	    }
	 
	public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
