package de.vitali.expensetracker;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);


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

                    scanner.nextLine();

                    System.out.println("Enter description:");
                    String incomeDescription  = scanner.nextLine();


                    System.out.println("Income added: " + income);
                    System.out.println("Description: " + incomeDescription );
                    transactions.add(new Transaction(TransactionType.INCOME, income, incomeDescription ));
                    break;
                case 2:
                    double expense = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter description:");
                    String expenseDescription  = scanner.nextLine();

                    System.out.println("Expense added: " + expense);
                    transactions.add(new Transaction(TransactionType.EXPENSE, expense, expenseDescription ));
                    break;
                case 3:
                    System.out.println("=== Transactions ===");

                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;
                case 4:
                    double calculatedBalance = calculateBalance(transactions);
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
    public static double calculateBalance(ArrayList<Transaction> transactions){
        double calculatedBalance = 0;
        for (Transaction transaction : transactions){
            if (transaction.getType() == TransactionType.INCOME) {
                calculatedBalance += transaction.getAmount();
            }
           else if (transaction.getType() == TransactionType.EXPENSE) {
                calculatedBalance -= transaction.getAmount();
            }
        }
        return calculatedBalance;
    }
}
