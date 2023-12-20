/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * CLass responsible for setting up a MySQL database USER, and create a table USERDB, 
 * and columns such as name,password,age,id and gross income.  
 * 
 * @author AdeliaAcacio2022203
 */
public class SetupUserDB {
     final static String DB_BASE_URL = "jdbc:mysql://localhost";
    final static String USER = "ooc2023";
    final static String PASSWORD = "ooc2023";
    
    public static boolean dbSetup() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
            //create a USER database and table with name,password,age,id and gross income
            stmt.execute("CREATE DATABASE IF NOT EXISTS user;");
            stmt.execute("USE user;");
            String sql = 
                    "CREATE TABLE IF NOT EXISTS userDB ("
                    + "name VARCHAR(255),"
                    + "password INT(10),"
                    + "age INT(2),"
                    + "id INT(10),"
                    + "gross_income DECIMAL(10,2)"
                    + ");";
            stmt.execute(sql);
            return true; //Return TRUE if there is no error
        } catch (Exception e) {
            e.printStackTrace();
            return false;//Return FALSE to indicate that setup is fail 
        }
    }
    
    
}
