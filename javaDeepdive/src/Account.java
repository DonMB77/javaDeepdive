public class Account {
    int id;
    StandardAccountOperations.Transaction[] transactions;

    public void sendMoneyToAccount (Account accountTo, double moneyAmount) {

    }

    public void withdrawMoney (double moneyAmount) {

    }

    //public StandardAccountOperations.Transaction[] getTransactions() {
    //
    //}

    public static class Transaction {
        Account accountFrom;
        Account accountTo;
        double moneyAmount;
        StandardAccountOperations operation;
    }
}
