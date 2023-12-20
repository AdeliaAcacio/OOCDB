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
public class Menu {
  

    Scanner scanner = new Scanner(System.in);
    ReaderDB readerDB = new ReaderDB();
    WriterDB writerDB = new WriterDB();
    User loggedInUser = null;
    TaxCalc taxCalculator = new TaxCalculator() {}; // Instantiate TaxCalculator

    public void startMenu() {
        while (true) {
            System.out.println("Welcome to the Tax Calculator");
            System.out.println("You would like to:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Please enter the number of your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    loggedInUser = loginUser(scanner, readerDB);
                    if (loggedInUser != null) {
                        if (loggedInUser instanceof Admin) {
                            adminMenu(scanner, (Admin) loggedInUser, readerDB);
                        } else {
                            regularUserMenu(scanner, (Regular_User) loggedInUser);
                        }
                    }
                    break;
                case 2:
                    registerUser(scanner, writerDB);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }

    private User loginUser(Scanner scanner, ReaderDB readerDB) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = readerDB.getUserByUsernameAndPassword(username, password);

        if (user == null) {
            System.out.println("Invalid username or password. Please try again.");
        } else {
            System.out.println("Login successful!");
        }

        return user;
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
            // Now, send the user to the tax calculator
            calculateTaxes(newUser);
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    private void regularUserMenu(Scanner scanner, Regular_User user) {
        while (true) {
            System.out.println("Welcome, " + user.getUserName() + "!");
            System.out.println("What option would you like?");
            System.out.println("1. Modify profile");
            System.out.println("2. Tax calculation");
            System.out.println("3. Leave");
            System.out.print("Please enter the number of your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    user.modifyProfile();
                    break;
                case 2:
                    // Implement tax calculation logic for regular user using taxCalculator
                    double grossIncome = user.getGrossIncome();
                    double payeTax = taxCalculator.calculatePayeTax(grossIncome);
                    double uscTax = taxCalculator.calculateUscTax(grossIncome, user.getUserAge());
                    double prsiTax = taxCalculator.calculatePrsiTax(grossIncome);

                    // Print the results for each tax
                    System.out.println("PAYE Tax: " + payeTax);
                    System.out.println("USC Tax: " + uscTax);
                    System.out.println("PRSI Tax: " + prsiTax);
                    break;
                case 3:
                    System.out.println("Goodbye, " + user.getUserName() + "!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }

    private void adminMenu(Scanner scanner, Admin admin, ReaderDB readerDB) {
        while (true) {
            System.out.println("Welcome, " + admin.getAdminUser() + "!");
            System.out.println("What option would you like?");
            System.out.println("1. Modify profile");
            System.out.println("2. Remove other users from the system");
            System.out.println("3. Review the operations performed by other users");
            System.out.println("4. Leave");
            System.out.print("Please enter the number of your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    admin.modifyProfile();
                    break;
                case 2:
                    // Implement logic to remove other users
                    break;
                case 3:
                    // Implement logic to review operations
                    break;
                case 4:
                    System.out.println("Goodbye, " + admin.getAdminUser() + "!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }
}




