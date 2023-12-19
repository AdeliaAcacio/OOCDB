/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class retrieve user data, interact with 'Database' interface and connect
 * to mysql constants 'DB_URL', 'USER', 'PASSWORD', and 'TABLE_NAME' using JAVA
 * DATABASE CONNECTIVITY
 *
 * Main code provide from Sam Weiss/hospitalAdministration, changes made to fit
 * the ReaderDB
 *
 * @author AdeliaAcacio2022203
 */
public class ReaderDB implements Database {

    /* Block inside 'try' establishes a connection to the database using the 'DriverManager' and creates a 'Statement' object for executing SQL queries
      Code executes a 'SELECT' sql query to write all table columns details 'FROM' specified tabe using the 'stmt and printing the results using 'results.next()'
         
    */

    public ArrayList<User> getAllData() {
        
    
       try {
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
               Statement stmt = conn.createStatement();) { 
               
           ResultSet results = stmt.executeQuery(String.format(
               "SELECT * FROM %s;",
               TABLE_NAME));

            // Selects row 1
            System.out.println(results.next());
            // Selects row 2
            System.out.println(results.next());
            // Selects row 3
            System.out.println(results.next());
            // Selects row 4
            System.out.println(results.next());
            System.out.println(results.next());
            System.out.println(results.getString("username"));
            System.out.println(results.getInt("userID"));

            // Catch block to catches exceptions that ours during executions of the program   
        }catch (Exception e) {
           // This line prints the informations about of sequence of methods that led to the exception
                e.printStackTrace();
        }
    }
    

        /**
    * Method to retrieve user information from the database based on the userID.
    *
    * @param userID the ID of the user to retrieve.
    * @return a User object representing the user's data, or null if an exception occurs.
    */
    public User getUserData(int userID) {
        try (
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);  
                Statement stmt = conn.createStatement()) {
            // Object that stores the result of our query
            ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s WHERE id=%d;",
                 TABLE_NAME, userID));
            results.next();

            //Getting user data to create a user object
            System.out.println(results.getString("userName"));
            String name = results.getString("userName");
            int password = results.getInt("userPassword");
            int id = results.getInt("userID");
            int age = results.getInt("userAge");
            double gI = results.getInt("grossIncome");
            //Writing data from the 'ResultSet' to create a new 'User' object
            User user = new User(name, password, id, age, gI);
            return user;

            // Catch block to catches exceptions that ours during executions of the program
        } catch (Exception e) {
            // This line prints the informations about of sequence of methods that led to the exception
            e.printStackTrace();
            return null;
        }
    }

}
