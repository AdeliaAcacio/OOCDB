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
    
    // Paye tax: deducted from employees 
    //Method used to take SALARY and retun the value of salary after calc deduction of PAYE tax
    double calculatePayeTax(double salary);
    //The Universal Social Charge (USC)
    // Method used to take SALARY and AGE retun the value of salary after calc deduction of USC tax

    /**
     *
     * @param salary
     * @param age
     * @return
     */
    double calculateUscTax(double salary, int age);
    //The Pay Related Social Insurance (PRSI)
    // Method used to take salary and retun the value of salary after calc deduction of PRSI tax
    
    
    double calculatePrsiTax(double salary);
}


   

