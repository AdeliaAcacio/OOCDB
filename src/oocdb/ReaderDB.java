/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static oocdb.Database.DB_BASE_URL;
import static oocdb.Database.PASSWORD;
import static oocdb.Database.USER;

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

    private ArrayList<User> users = new ArrayList<>();
    
    public ArrayList<User> getAllData() {
        
    
       try (
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
               Statement stmt = conn.createStatement()) { 
               
           ResultSet results = stmt.executeQuery(String.format(
               "SELECT * FROM %s;",
               TABLE_NAME));

            while (results.next()) {
                String userName = results.getString("userName");
                String password = results.getString("userPassword");
                int userID = results.getInt("userID");
                int userAge = results.getInt("userAge");
                double grossIncome = results.getDouble("grossIncome");  
                User user = new User(userName, password, userID, userAge, grossIncome);
                users.add(user);
            }

            // Catch block to catches exceptions that ours during executions of the program   
        }catch (Exception e) {
           // This line prints the informations about of sequence of methods that led to the exception
                e.printStackTrace();
        }
        return users;
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
            
           
            //Getting user data to create a user object
            if (results.next()) {
                String userName = results.getString("userName");
                String password = results.getString("userPassword");
                int retrievedUserID = results.getInt("userID");
                int userAge = results.getInt("userAge");
                double grossIncome = results.getInt("grossIncome");
                 //Writing data from the 'ResultSet' to create a new 'User' object
           
                return new User(userName, password, retrievedUserID, userAge, grossIncome);
            }
            // Catch block to catches exceptions that ours during executions of the program
        } catch (Exception e) {
            // This line prints the informations about of sequence of methods that led to the exception
            e.printStackTrace();
        }
        return null;
    }
     // retrieving grossIncome and age from the database
    public double retrieveGrossIncomeFromDatabase(int userId) {
        double grossIncome = 0;

        try (Connection connection = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD)) {
            String sql = "SELECT grossIncome FROM users WHERE userID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        grossIncome = resultSet.getDouble("grossIncome");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return grossIncome;
    }

   public int retrieveAgeFromDatabase(int userId) {
        int age = 0;

        try (Connection connection = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD)) {
            String sql = "SELECT userAge FROM users WHERE userID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        age = resultSet.getInt("userAge");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return age;
    }

    User getUserByUsernameAndPassword(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
