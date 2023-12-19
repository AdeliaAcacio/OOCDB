/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.sql.SQLException;


/**
 *
 * @author AdeliaAcacio
 */
public class Prototype_software {
    
     public static void main(String[] args)throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessExceptio {
        // TODO code application logic here  
        
        
        
        ReaderDB readerdb = new ReaderDB();
        System.out.println(User.getCurrentID());
        readerdb.getAllData();
        readerdb.getUserData(1);
        readerdb.getUserData(2);
        System.out.println(User.getCurrentID());
        
        
        
         // Retrieve grossIncome and age from the database
        double grossIncome = retrieve.GrossIncomeFromDatabase();
        int age = retrieveAgeFromDatabase();

        // Create an instance of the TaxCalculator
        TaxCalc taxCalculator = new TaxCalculator() {};

        // Calculate taxes using the interface methods
        double payeTax = taxCalculator.calculatePayeTax(grossIncome);
        double uscTax = taxCalculator.calculateUscTax(grossIncome, age);
        double prsiTax = taxCalculator.calculatePrsiTax(grossIncome);

        // Print the results
        System.out.println("PAYE Tax: " + payeTax);
        System.out.println("USC Tax: " + uscTax);
        System.out.println("PRSI Tax: " + prsiTax);
    }

    // CHECK THIS CODIGO
     // retrieving grossIncome and age from the database
    private static double retrieve.GrossIncomeFromDatabase() {
        // 
        return grossIncome;
    }

    private static int retrieveAgeFromDatabase() {
        // 
        return userAge;
    }

    
    }
     

