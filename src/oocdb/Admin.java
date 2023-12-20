/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

/**
 *
 * @author Stefani Nunes
 */
public class Admin  implements UserInterface{
    
     private String adminUser = "CCT";
     private String adminPassword = "Dublin";
   
    //CONSTRUCTOR 

    public Admin(String username, String password, int currentID) {
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public String getAdminPassword() {
        return adminPassword;
    }


   
    @Override
    public void modifyProfile(){
         //to modify their onw profile
        
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
