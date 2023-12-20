/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.util.Scanner;

/**
 *
 * @author Stefani Nunes
 */
public class Regular_User extends User implements UserInterface{

    public Regular_User(String userName, String userPassword, int userID, int userAge, double grossIncome) {
        super(userName, userPassword, userID, userAge, grossIncome);
    }
     
 private void registerUser(Scanner scanner, WriterDB writerDB) {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    Regular_User newUser = new Regular_User(username, password, User.getCurrentID(), 0, 0.0);
    boolean registrationSuccess = writerDB.addUser(newUser);

    if (registrationSuccess) {
        System.out.println("Registration successful!");

        // Now, you can perform additional actions or calculations for the new user
        // For example, calculate taxes for the new user
        double grossIncome = newUser.getGrossIncome();
        double payeTax = taxCalculator.calculatePayeTax(grossIncome);
        double uscTax = taxCalculator.calculateUscTax(grossIncome, newUser.getUserAge());
        double prsiTax = taxCalculator.calculatePrsiTax(grossIncome);

        // Print the results for each tax
        System.out.println("PAYE Tax: " + payeTax);
        System.out.println("USC Tax: " + uscTax);
        System.out.println("PRSI Tax: " + prsiTax);
    } else {
        System.out.println("Registration failed. Please try again.");
    }
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
