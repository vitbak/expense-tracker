package de.vitali.expensetracker;
import java.util.ArrayList;
public class ExpenseTracker {
    private ArrayList<Transaction> transactions;
        public ExpenseTracker(){
            transactions = new ArrayList<>();
        }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public void showTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public double calculateBalance() {
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
