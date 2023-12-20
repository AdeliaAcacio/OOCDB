/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

/**
 *
 * @author Stefani Nunes
 */
public class Admin extends User implements UserInterface{
    
     // private String adminUser = "CCT";
     // private String adminPassword = "Dublin";
   
    CONSTRUCTOR *** WE NEED TO CREATE A NEW ADMIN? BECAUSE THIS CONSTRUCTOR WILL CREATE A NEW ADMIN, RIGHT?????****
    
    public Admin(String userName, String userPassword, int userID, int userAge, double grossIncome) {
        super(userName, userPassword, userID, userAge, grossIncome);
    }

    @Override
    public void modifyProfile(){
         //to modify their onw profile
        
    }
    @Override
    // if the used username and password matches the admin choise
    public boolean login(String userUserName, String userPassword) {
        return getUserName().equals(userUserName) && getUserPassword().equals(userPassword);
    }
    
  //METHODS DECLARATIONS  
    public void accessUsers(){
        //to access a list of all users
    }
    
    public void removeUsers(User user){
        //to remove other users from the system
    }
    
    public void reviewOperations(){
        //to review operations performed by others users
    }
}
