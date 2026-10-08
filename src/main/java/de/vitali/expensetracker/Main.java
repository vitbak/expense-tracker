package de.vitali.expensetracker;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        ExpenseTracker expenseTracker = new ExpenseTracker();
        expenseTracker.loadFromFile();
        while (true) {
            System.out.println("=== Expense Tracker===");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. Show transactions");
            System.out.println("4. Show balance");
            System.out.println("5. Delete transaction");
            System.out.println("6. Edit transaction");
            System.out.println("0. Exit");
            System.out.println("Choose option:");

            int choice = readChoice(scanner);

            switch (choice) {
                case 1:
                    double income = readAmount(scanner);


                    System.out.println("Enter description:");
                    String incomeDescription = scanner.nextLine();


                    System.out.println("Income added: " + income);
                    System.out.println("Description: " + incomeDescription);
                    expenseTracker.addTransaction(
                            new Transaction(TransactionType.INCOME, income, incomeDescription));
                    expenseTracker.saveToFile();
                    break;
                case 2:
                    double expense = readAmount(scanner);


                    System.out.println("Enter description:");
                    String expenseDescription = scanner.nextLine();

                    System.out.println("Expense added: " + expense);
                    expenseTracker.addTransaction(
                            new Transaction(TransactionType.EXPENSE, expense, expenseDescription));
                    expenseTracker.saveToFile();
                    break;
                case 3:
                    System.out.println("=== Transactions ===");

                    expenseTracker.showTransactions();
                    break;
                case 4:
                    double calculatedBalance = expenseTracker.calculateBalance();
                    System.out.println("Current balance: " + calculatedBalance);
                    break;
                case 5: {
                    expenseTracker.showTransactions();

                    System.out.println("Enter transaction number to delete:");

                    int number = readTransactionNumber(scanner, expenseTracker);
                    if (number == -1) {
                        break;
                    }

                    expenseTracker.deleteTransaction(number - 1);
                    expenseTracker.saveToFile();
                }

                break;
                case 6: {
                    expenseTracker.showTransactions();
                    System.out.println("Enter transaction number to edit:");
                    int number = readTransactionNumber(scanner, expenseTracker);
                    if (number == -1) {
                        break;
                    }
                    System.out.println("Enter new amount:");
                    double amount = readAmount(scanner);
                    System.out.println("Enter new description:");
                    String description = scanner.nextLine();
                    expenseTracker.updateTransaction(number - 1, amount, description);
                    expenseTracker.saveToFile();
                    break;
                }
                case 0: {
                    System.out.println("Exit");
                    return;
                }
                default:
                    System.out.println("Invalid option");
            }

        }
    }

    public static int readChoice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                scanner.nextLine();
            } else {

                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 6) {
                    scanner.nextLine();
                    return choice;
                } else {
                    System.out.println("Enter a number from 0 to 6.");
                    scanner.nextLine();
                }

            }
        }
    }

    public static int readTransactionNumber(
            Scanner scanner,
            ExpenseTracker expenseTracker) {
        if (expenseTracker.getTransactionCount() == 0) {
            System.out.println("No transactions available.");
            return -1;
        }
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                scanner.nextLine();

            } else {
                int number = scanner.nextInt();
                scanner.nextLine();

                if (number >= 1 &&
                        number <= expenseTracker.getTransactionCount()) {

                    return number;
                } else {
                    System.out.println("Invalid transaction number.");
                }
            }
        }
    }

    public static double readAmount(Scanner scanner) {
        while (true) {
            System.out.println("Enter amount: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input");
                scanner.nextLine();
            } else {
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Enter a number greater than zero.");
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    return amount;

                }
            }
        }

    }

}


