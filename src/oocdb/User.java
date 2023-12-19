/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

/**
 *
 * @author Stefani Nunes & AdeliaAcacio2022203
 */

//User interface
interface UserInterface{
public void modifyProfile();
}


public class User {
    
    //ATTRIBUTES : Fields that represents user attributes 
    private String userName;
    private final int userPassword;
    private final int userID;
    private final int userAge;
    protected double userSalary;
    

    private static final int currentID = 1;
    
    //CONSTRUCTOR to build new User
    public User(String userName, int userPassword, int userID, int userAge, double userSalary) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userID = userID;
        this.userAge = userAge;
        this.userSalary = userSalary;
    }

    //METHODS: GETTER to retrieve the values of the User attributes
    public String getUserName() {
        return userName;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public int getUserID() {
        return userID;
    }

    public int getUserAge() {
        return userAge;
    }

    public double getUserSalary() {
        return userSalary;
    }

    public static int getCurrentID() {
        return currentID;
    }
    //SETTER to set the value of the 'userName' attribute.
    public void setUsername(String userName) {
        this.userName = userName;
    }
    
    
    
    // if the used username and password matches the users choise
    public boolean login(String userUsername, String userPassword){
        return this.username.equals(userUsername) && this.userPassword.equals(userPassword);
    }

 
  
    
}
