/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Code designed for writing user details to a MySQL database
 * 
 * Main code provide from Sam Weiss/hospitalAdministration
 * Changes made to fit the WriterDB
 * @author AdeliaAcacio2022203
 */
public class WriterDB implements Database {
    
        //adding a single user to the database
       //throws a SQLException, if occur a problem withe the database connecction or at the operation of write a new user
    public boolean addUser (User user) throws SQLException {
        try(
            // Using try-with-resources to automatically close resources 'Connection' and 'Statement'
             Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement()){  
        
            // Using User details to building the SQL database
            String sql = String.format("INSERT INTO %s (userName, userPassword, userID, userAge) VALUES " +
                    "('%s', '%s', %d, %d);", TABLE_NAME, user.getUserName(), user.getUserPassword(),
                    user.getUserID(), user.getUserAge()); 
           //execute sql statement
            stmt.execute(sql);
            return true;        
                         
                         
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
        // Adding a array list of users to the database (currently returns true, needs implementation)
       public boolean addAllUsers(List<User> userList) {
          // adding all users in the database list
           return false;
       } 
    }

