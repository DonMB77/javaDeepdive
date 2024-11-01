package moneyTransfer;

import java.util.ArrayList;

public class Account {
    int id;
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    double currentAmountMoney;

    public Account (int id, double currentAmountMoney) {
        this.id = id;
        this.currentAmountMoney = currentAmountMoney;
    }

    public void sendMoneyToAccount (Account accountTo, double moneyAmount) {
        if (this.currentAmountMoney < moneyAmount) {
            System.out.println("Not enough money in account. Cannot finish transfer.");
        } else {
            this.currentAmountMoney -= moneyAmount;
            accountTo.currentAmountMoney += moneyAmount;
        }
    }

    public void withdrawMoney (double moneyAmount) {

    }

    //public moneyTransfer.StandardAccountOperations.Transaction[] getTransactions() {
    //
    //}

    public static class Transaction {
        Account accountFrom;
        Account accountTo;
        double moneyAmount;

        public Transaction(Account accountFrom, Account accountTo, double moneyAmount) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
        }

        public Transaction inputTransaction () {
            return new Transaction(accountFrom, accountTo, moneyAmount);
        }
    }
}
