/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

/**
 *
 * @author Stefani Nunes
 */
public class Regular_User extends User implements UserInterface{
     
   
//CONSTRUCTOR
    public Regular_User(String userName, String userPassword, int userID, int userAge, double grossIncome) {
        super(userName, userPassword, userID, userAge, grossIncome);
    }
    
   @Override
    public void modifyProfile(){
         //// Implement modification for RegularUsers profile
        
    }
    
    @Override
    // if the used username and password matches the users choise
    public boolean login(String userUserName, String userPassword){
        return getUserName().equals(userUserName) && getUserPassword().equals(userPassword);
    }
   
}
