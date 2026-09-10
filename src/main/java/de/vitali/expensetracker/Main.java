package de.vitali.expensetracker;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            double balance = 0;

        ArrayList<Transaction> transactions = new ArrayList<>();
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
                    balance = balance + income;
                    System.out.println("Income added: " + income);
                    System.out.println("Current balance: " + balance);
                    transactions.add(new Transaction("Income", income));
                    break;
                case 2:
                    double expense = scanner.nextDouble();
                    balance = balance - expense;
                    System.out.println("Expense added: " + expense);
                    System.out.println("Current balance: " + balance);
                    transactions.add(new Transaction("Expense", expense));
                    break;
                case 3:
                    System.out.println("=== Transactions ===");

                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.type + ": " + transaction.amount);
                    }
                    break;
                case 4:
                    System.out.println("Current balance: " + balance);
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
