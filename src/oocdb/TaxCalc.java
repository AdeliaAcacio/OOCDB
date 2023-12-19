/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package oocdb;

/**
 *The codes below represent the the amount of tax that people from Ireland have to
 * pay for each category
 * @author AdeliaAcacio
 */

 //This interface has three methods to calculate tax  
public interface TaxCalc {
    
    // Paye tax: 'Pay As You Ern' deducted from employees (Every time the employee salary is paid, employer deducts Income Tax
    //Method used to take gross income and retun the value of salary after calculation to deduct value of PAYE tax
    double calculatePayeTax(double grossIncome);
    

    /**
     * The Universal Social Charge (USC)
     * Method used to take gross income and AGE return the value of salary after calculation to deduct value of USC tax
     * @param salary
     * @param age
     * @return the value of salary after calculate deduction of USC tax
     */
    double calculateUscTax(double grossIncome, int age);
    
    //The Pay Related Social Insurance (PRSI)
    // Method used to take gross income and retun the value of salary after calculation to deduct value of PRSI tax
    double calculatePrsiTax(double grossIncome);
}


   

