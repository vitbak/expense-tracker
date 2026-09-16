package de.vitali.expensetracker;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);



        ExpenseTracker expenseTracker = new ExpenseTracker();
        while (true) {
            System.out.println("=== Expense Tracker===");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. Show transactions");
            System.out.println("4. Show balance");
            System.out.println("0. Exit");
            System.out.println("Choose option:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    double income = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.println("Enter description:");
                    String incomeDescription  = scanner.nextLine();


                    System.out.println("Income added: " + income);
                    System.out.println("Description: " + incomeDescription );
                    expenseTracker.addTransaction(
                            new Transaction(TransactionType.INCOME, income, incomeDescription));
                    break;
                case 2:
                    double expense = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter description:");
                    String expenseDescription  = scanner.nextLine();

                    System.out.println("Expense added: " + expense);
                    expenseTracker.addTransaction(
                            new Transaction(TransactionType.EXPENSE, expense, expenseDescription));
                    break;
                case 3:
                    System.out.println("=== Transactions ===");

                    expenseTracker.showTransactions();
                    break;
                case 4:
                    double calculatedBalance = expenseTracker.calculateBalance();
                    System.out.println("Current balance: " + calculatedBalance);
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

}
