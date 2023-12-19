/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

/**
 *
 * @author AdeliaAcacio
 */
public class Prototype_software {
    
     public static void main(String[] args) {
        // TODO code application logic here  
        
         // Retrieve salary and age from the database
        double salary = retrieveSalaryFromDatabase();
        int age = retrieveAgeFromDatabase();

        // Create an instance of the DefaultTaxCalculator
        TaxCalculator taxCalculator = new DefaultTaxCalculator();

        // Calculate taxes using the interface methods
        double payeTax = taxCalculator.calculatePayeTax(salary);
        double uscTax = taxCalculator.calculateUscTax(salary, age);
        double prsiTax = taxCalculator.calculatePrsiTax(salary);

        // Print the results
        System.out.println("PAYE Tax: " + payeTax);
        System.out.println("USC Tax: " + uscTax);
        System.out.println("PRSI Tax: " + prsiTax);
    }

    // ALTERAR CODIGO
     // retrieving salary and age from the database
    private static double retrieveSalaryFromDatabase() {
        // 
        return userSalary;
    }

    private static int retrieveAgeFromDatabase() {
        // 
        return age;
    }
    }
     
}
