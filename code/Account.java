/*
The Account class represents a bank account entity, encapsulating attributes 
such as accountNumber, accountHolderName, balance, username, and password. 
Additionally, it maintains a list of transaction history to track account activities. 
The constructor initializes these attributes based on provided parameters and 
initializes the transaction history list. Accessor and mutator methods are provided to 
retrieve and modify account information, including balance, transaction history, 
account number, username, password, and account holder name. Methods like displayBalance() 
and displayAccountDetails() facilitate the display of account balance and 
detailed account information respectively. The class also includes a getHead() method, 
suggesting a possible association with a linked list structure, although this attribute is 
not utilized within the class methods. Overall, the Account class serves as a 
foundational component for managing bank accounts within a banking system.
 */

import java.util.ArrayList;
import java.util.List;

class Account {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected String username;
    protected String password;
    private AccountNode head;
    private List<Transaction> transactionHistory;


    public Account(String accountNumber, String accountHolderName, double balance, String username, String password) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.transactionHistory = new ArrayList<>();
    }

    public void displayBalance() {
        System.out.println("Current balance : $ " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void displayAccountDetails() {
        System.out.println("=========================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Name   : " + accountHolderName);
        System.out.println("Username       : " + username);
        System.out.println("Balance        : $ " + balance);
        System.out.println("=========================");
    }

    public AccountNode getHead() {
        return head;
    }

    public void removeTransaction(Transaction lastTransaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTransaction'");
    }

}