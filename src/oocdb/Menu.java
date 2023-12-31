/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocdb;

import java.sql.SQLException;
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
    
     public static void main(String[] args) throws SQLException {
          // Instantiate Menu and call startMenu
        Menu menu = new Menu();
        try {
            menu.startMenu();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

     
       
    private void startMenu() throws SQLException {
        while (true) {
            System.out.println("Welcome to the Tax Calculator");
            System.out.println("You would like to:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Please enter the number of your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Please choose the type of user:");
                    System.out.println("1. Admin");
                    System.out.println("2. Regular User");
                    System.out.print("Enter the number of your choice: ");
                    int userTypeChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (userTypeChoice) {
                        case 1:
                Admin loginAdmin = loginAdmin(scanner);
                            if (loggedInUser != null) {
                                adminMenu(scanner, (Admin) loginAdmin, readerDB);
                            }
                            break;

                        case 2:
                            loggedInUser = loginUser(scanner);
                            if (loggedInUser != null) {
                                regularUserMenu(scanner, (Regular_User) loggedInUser);
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 or 2.");
                            break;
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



   // Inside the Menu class
private Admin loginAdmin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (username.equalsIgnoreCase("cct") && password.equals("dublin")) {
            // Admin login
            Admin admin = new Admin(username, password, User.getCurrentID());
            System.out.println("Admin login successful!");
            return admin;
        } else {
            System.out.println("Invalid admin username or password. Please try again.");
            return null;
        }
    }

    private Regular_User loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Regular user login
        User user = readerDB.getUserByUsernameAndPassword(username, password);

        if (user == null) {
            System.out.println("Invalid username or password. Please try again.");
        } else {
            System.out.println("Login successful!");
            System.out.println("Welcome, " + user.getUserName() + "!");
            return (Regular_User) user;
        }

        return null;
    }

    private void registerUser(Scanner scanner, WriterDB writerDB) throws SQLException {
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
                removeUsers();
                break;
            case 3:
                reviewOperations();
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

// Implement the logic to remove other users
private void removeUsers() {
    System.out.print("Enter the username of the user to remove: ");
    String usernameToRemove = scanner.nextLine();

    // Implement logic to remove the user with the specified username
    // You can use the WriterDB or any appropriate method to remove the user
    // For example: writerDB.removeUserByUsername(usernameToRemove);
    System.out.println("User " + usernameToRemove + " removed successfully.");
}

// Implement the logic to review operations
private void reviewOperations() {
    // Implement logic to display and review the operations performed by other users
    // You can use the ReaderDB or any appropriate method to retrieve and display operations
    // For example: readerDB.displayOperations();
    System.out.println("Reviewing operations...");
}

    private void calculateTaxes(Regular_User newUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}




