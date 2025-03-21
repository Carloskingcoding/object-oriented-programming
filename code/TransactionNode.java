/*
The TransactionNode class represents a node in a linked list structure, specifically designed for storing transaction details. 
Each TransactionNode instance contains information about a single transaction, including its ID, amount, type, and date.
 Additionally, it maintains references to the next and previous nodes in the linked list (next and previous respectively).
Furthermore, it holds a reference to the head of an associated account linked list (head), 
allowing transactions to be associated with specific accounts.
The class includes methods for setting and getting references to the next and previous nodes 
(setNext(), getNext(), setPrev(), getPrev()), as well as methods for setting and getting references to associated 
TransactionNode instances (setTransactionNode(), getTransactionNode()), and for setting and getting the associated Transaction object 
(setTransaction(), getTransaction()).
Additionally, it provides a method printTransactionDetails() for printing the details of the transaction in a formatted manner,
including its ID, amount, type, and date. 
*/

import java.time.LocalDate;

public class TransactionNode {
    private int transactionId;
    private double amount;
    private String type;
    private LocalDate transactionDate;
    private TransactionNode next;
    private TransactionNode previous;
    private AccountNode head;
    private TransactionNode transactionNode;
    private Transaction transaction;


    public TransactionNode(int transactionId, double amount, String type, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.transactionDate = transactionDate;
        this.transaction = null;
        this.next = null;
        this.previous = null;
        this.transactionNode = null;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }

    public TransactionNode getNext() {
        return next;
    }

    public void setPrev(TransactionNode prev) {
        this.previous = prev;
    }

    public TransactionNode getPrev() {
        return previous;
    }

    public void setTransactionNode(TransactionNode transactionNode) {
        this.transactionNode = transactionNode;
    }

    public TransactionNode getTransactionNode() {
        return transactionNode;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public AccountNode getHead() {
        return head;
    }

    public void setHead(AccountNode head) {
        this.head = head;
    }

    public void printTransactionDetails() {
        System.out.printf("Transaction ID: %d, Amount: %.2f, Type: %s, Date: %s\n",transactionId, amount, type, transactionDate.toString());
    }

        
}