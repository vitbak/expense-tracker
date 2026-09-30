package de.vitali.expensetracker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExpenseTracker {

    private ArrayList<Transaction> transactions;

    public ExpenseTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void showTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public double calculateBalance() {
        double calculatedBalance = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                calculatedBalance += transaction.getAmount();
            } else if (transaction.getType() == TransactionType.EXPENSE) {
                calculatedBalance -= transaction.getAmount();
            }
        }

        return calculatedBalance;
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("transactions.txt")) {

            for (Transaction transaction : transactions) {
                writer.write(
                        transaction.getType().toString()
                                + ";"
                                + String.valueOf(transaction.getAmount())
                                + ";"
                                + transaction.getDescription()
                                + "\n"
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("transactions.txt"))) {

            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split(";");

                TransactionType type =
                        TransactionType.valueOf(parts[0]);

                double amount =
                        Double.parseDouble(parts[1]);

                String description = parts[2];

                Transaction transaction =
                        new Transaction(type, amount, description);

                addTransaction(transaction);

                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("No saved transactions yet.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}