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

    String name;
    String surname;
   
    //CONSTRUCTOR

    public Admin(String name, String surname, String username, String password) {
        super(username, password);
        this.name = name;
        this.surname = surname;
    }

    @Override
    public void modifyProfile(){
         //to modify their onw profile
        
    }
    @Override
    // if the used username and password matches the admin choise
    public boolean login(String userUsername, String userpassword){
        return this.username.equals(userUsername) && this.password.equals(userpassword);
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
