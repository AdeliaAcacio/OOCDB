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
    
    public static final String DB_BASE_URL = "jdbc:mysql://localhost";
    public static final String USER = "ooc2023";
    public static final String PASSWORD = "ooc2023";
    public static final String DB_NAME = "users";
    public static final String TABLE_NAME = "user_details";
    
    public static final String DB_URL = DB_BASE_URL + "/" + DB_NAME;
    
}
    

