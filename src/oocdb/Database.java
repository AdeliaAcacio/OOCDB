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
    
    protected final static String DB_BASE_URL = "";  // EXAMPLE : jdbc:mysql://localhost/hospital
    protected final static String USER = "ooc2023";
    protected final static String PASSWORD = "ooc2023";
    protected final static String DB_NAME = "users";
    protected final static String TABLE_NAME1 = "user_details";
    protected final static double TABLE_NAME2 = "user_salary"; //create a user salary table at the MYSQL DOUBLE
   
    
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
    
}
    

