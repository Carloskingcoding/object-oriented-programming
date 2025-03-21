/*
The Transaction class encapsulates details about a transaction, such as its type, amount, date, and associated account number. 
After the transaction have been made, it initializes these attributes based on the provided parameters.
Accessor methods (getType(), getAmount(), getDate(), getAccountNumber()) allow retrieval of the transaction's type, 
amount, date, and account number respectively, while mutator methods (setType(), setAmount(), setDate(), setAccountNumber()) 
enable modification of these attributes.
The type attribute denotes the nature or category of the transaction, while amount represents the  value involved.
The date attribute stores the date when the transaction occurred, and accountNumber identifies the account associated with the transaction.

Overall, the Transaction class serves as a container for organizing and managing individual financial transactions within a larger system. 
*/

import java.time.LocalDate;

public class Transaction {
    private String type;
    private double amount;
    private LocalDate date;
    private String accountNumber;


    public Transaction(String type, double amount, LocalDate date, String accountNumber) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
