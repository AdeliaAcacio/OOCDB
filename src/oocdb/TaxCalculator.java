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
    *if grossIncome => 40000 (salary * 0.2)  grossIncome - 20%
    *If grossIncome =< 40001 (PAYE TAX Result =( (grossIncome - 40000 ) * 0.4))
    *if (PAYE TAX Result > 7176 ) else(PAYE TAX Result = 7176)
 
    *USC TAX 
    *if (grossIncome => 12012 && Age > 70) {grossIncome * 0.005} 
    *if (grossIncome >= 12013 || Salary => 22920)  calc {grossIncome * 0.02}
    *if (grossIncome >= 22921 || Salary => 70044) calc {grossIncome * 0.045}
    *if (grossIncome > 70045) calc (grossIncome * 0.08)
    *If (PAYE USC Result > 1353 ) maximum applied PAYE TAX Result is 1353

    *PRSI TAX  
    *if grossIncome  <= 1872 ( PRSI tax result = grossIncome * 0.4) 
    *if (PRSI tax result > 1873 ) else (PRSI tax result = 1873 )
 */
    public abstract class TaxCalculator implements TaxCalc {

    @Override
    // Method used to take grossIncome and retun the value of salary after calc deduction of PAYE tax
    public double calculatePayeTax(double grossIncome) {
        double payeTax;

        // If grossIncome is less than or equal to 40000
        if (salary <= 40000) {
            //deduction of 20% of grossIncome
            payeTax = grossIncome * 0.2;
            } else {
            // If grossIncome is greater than 40000, the first 40000 is deduced 20% of grossIncome
            double result = (grossIncome - 40000);
            // and the value up 40000 is deduced 40% of the grossIncome
            payeTax = 40000 * 0.2 + (result * 0.4);

            //check if the amount of PAYE tax is greater than 7176
            if (payeTax > 7176) {
                payeTax = 7176; // the maximum of PAYE tax deduction is 7176
            }
        }
            return payeTax;
            }

    
        // Method used to take GROSS INCOME and AGE and retun the  NET INCOME (value after deduction of USC tax)
    @Override
    public double calculateUscTax(double grossIncome, int age) {
            double uscTax;

            //If If grossIncome is greater than or equal to 12012 AND The person age is greater than 70 years old
            if (salary >= 12012 && age > 70) {
                //the USC tax deduction applied is 5%
                uscTax = salary * 0.005;
                //If grossIncome is greater than or equal to 12013 AND greater than 22920
            } else if (salary >= 12013 && salary < 22920) {
                //the USC tax deduction apllied is 2%
                uscTax = salary * 0.02;
                //If grossIncome is greater than or equal to 22921 AND greater than 70044
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

       

        // Method used to take grossIncome and retun the NET INCOME (value after deduction of PRSI tax)
    @Override
        public double calculatePrsiTax(double grossIncome) {
            double prsiTax = 0;

            // If grossIncomeis less than or equal to 40000
            if (salary <= 1872) {
                //deduction of 40% of salary applied
                prsiTax = salary * 0.4;
            } else {
                //check if the amount of PRSI tax calculated is greater than 1873
                // if yes, iT keeps the amount of 1873
                prsiTax = (prsiTax > 1873) ? 1873 : prsiTax;
           
             }

             return prsiTax;
        }
 }

