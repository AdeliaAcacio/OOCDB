/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

/**
 * This code provide the implementation for the calculation tax (PAYE, USC,
 * PRSI) from Ireland
 *
 * @author AdeliaAcacio2022203 & Stefani Nunes
 */
/*
    *PAYE TAX 
    *if Salary  => 40000 (salary * 0.2)  salary - 20%
    *If Salary =< 40001 (PAYE TAX Result =( (Salary - 40000 ) * 0.4))
    *if (PAYE TAX Result > 7176 ) else(PAYE TAX Result = 7176)
 
    *USC TAX 
    *if (Salary => 12012 && Age > 70) {salary * 0.005} 
    *if (Salary >= 12013 || Salary => 22920)  calc {salary * 0.02}
    *if (Salary >= 22921 || Salary => 70044) calc {salary * 0.045}
    *if ( Salary > 70045) calc (salary * 0.08)
    *If (PAYE USC Result > 1353 ) maximum applied PAYE TAX Result is 1353

    *PRSI TAX  
    *if Salary  <= 1872 ( PRSI tax result = salary * 0.4) 
    *if (PRSI tax result > 1873 ) else (PRSI tax result = 1873 )
 */
    public abstract class TaxCalculator implements TaxCalc {

    @Override
    // Method used to take salary and retun the value of salary after calc deduction of PAYE tax
    public double calculatePayeTax(double salary) {
        double payeTax;

        // If salary is less than or equal to 40000
        if (salary <= 40000) {
            //deduction of 20% of salary
            payeTax = salary * 0.2;
            } else {
            // If salary is greater than 40000, the first 40000 is deduced 20% of salary
            double result = (salary - 40000);
            // and the value up 40000 is deduced 40% of the salary
            payeTax = 40000 * 0.2 + (result * 0.4);

            //check if the amount of PAYE tax is greater than 7176
            if (payeTax > 7176) {
                payeTax = 7176; // the maximum of PAYE tax deduction is 7176
            }
        }
            return payeTax;
            }

    
        // Method used to take SALARY and AGE and retun the value of salary after deduction of USC tax
    @Override
    public double calculateUscTax(double salary, int age) {
            double uscTax;

            //If If salary is greater than or equal to 12012 AND The person age is greater than 70 years old
            if (salary >= 12012 && age > 70) {
                //the USC tax deduction applied is 5%
                uscTax = salary * 0.005;
                //If salary is greater than or equal to 12013 AND greater than 22920
            } else if (salary >= 12013 && salary < 22920) {
                //the USC tax deduction apllied is 2%
                uscTax = salary * 0.02;
                //If salary is greater than or equal to 22921 AND greater than 70044
            } else if (salary >= 22921 && salary < 70044) {
                // the USC tax deduction applied is 4.5%
                uscTax = salary * 0.045;
                //
            } else {
                uscTax = salary * 0.08;//8%
            }
            // Check if USC tax is greater than 1353, apply maximum of 1353
            if (uscTax > 1353) {
                uscTax = 1353;
            }

            return uscTax;
            }

       

        // Method used to take salary and retun the value of salary after deduction of PRSI tax
    @Override
        public double calculatePrsiTax(double salary) {
            double prsiTax = 0;

            // If salary is less than or equal to 40000
            if (salary <= 1872) {
                //deduction of 40% of salary applied
                prsiTax = salary * 0.4;
            } else {
                //check if the amount of PRSI tax calculated is greater than 1873
                // if yes, keep the amount of 1873
                prsiTax = (prsiTax > 1873) ? 1873 : prsiTax;
           
             }

             return prsiTax;
        }
 }

