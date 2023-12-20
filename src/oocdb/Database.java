/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package oocdb;

/**
 *The field below store the information created in MySQL
 * @author AdeliaAcacio2022203
 */
public interface Database {
    
    /*
    This method can be accessed from the same packege
    The variables can not be changed
    and the variables in Uppercase means it is a Final method
    */
    
    String DB_BASE_URL = "jdbc:mysql://localhost";  
    String USER = "ooc2023";
    String PASSWORD = "ooc2023";
    String DB_NAME = "users";
    String TABLE_NAME = "user_details";
    
   
    
    String DB_URL = DB_BASE_URL + "/" + DB_NAME;
    
}
    

