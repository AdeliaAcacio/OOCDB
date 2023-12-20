/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.util.ArrayList;


/**
 *
 * @author AdeliaAcacio
 * @author Stefani Nunes
 * GitHub link( https://github.com/AdeliaAcacio/OOCDB )
 */
public class Prototype_software {
    
     public static void main(String[] args) {
        // TODO code application logic here  
        
        
        
        ReaderDB readerdb = new ReaderDB();
        System.out.println(User.getCurrentID());
        
        ArrayList<User> allData = readerdb.getAllData();
        readerdb.getUserData(1);
        readerdb.getUserData(2);
        System.out.println(User.getCurrentID());
        
        
        
         // Retrieve grossIncome and age from the database
         double grossIncome = retrieveGrossIncomeFromDatabase();
         int age = retrieveAgeFromDatabase();

        // Create an instance of the TaxCalculator
        TaxCalc taxCalculator = new TaxCalculator() {};

        // Calculate taxes using the interface methods
        double payeTax = taxCalculator.calculatePayeTax(grossIncome);
        double uscTax = taxCalculator.calculateUscTax(grossIncome, age);
        double prsiTax = taxCalculator.calculatePrsiTax(grossIncome);

        // Print the results for each tax
        System.out.println("PAYE Tax: " + payeTax);
        System.out.println("USC Tax: " + uscTax);
        System.out.println("PRSI Tax: " + prsiTax);
    }

    
     // retrieving grossIncome and age from the database
    private static double retrieveGrossIncomeFromDatabase() {
        // 
        return 0;
    }

    private static int retrieveAgeFromDatabase() {
        // 
        return 0;
    }

    
    }
     

