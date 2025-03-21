/*
The AccountNode class represents a node in a linked list structure, 
specifically tailored for storing Account objects. Each node contains a reference to 
an Account instance, denoted by the account attribute. It also maintains references to 
the next and previous nodes in the list through the next and prev attributes respectively. 
The constructor initializes these attributes based on the provided Account object, 
setting both next and prev to null initially. Accessor and mutator methods 
are provided for accessing and modifying the Account object and the next and previous nodes 
in the list. Overall, the class encapsulates the essential components of a node 
within a linked list of Account objects, facilitating efficient traversal and 
manipulation of the list structure.
 */

public class AccountNode {
    private Account account;
    private AccountNode next;
    private AccountNode prev;

    public AccountNode(Account transaction) {
        this.account = transaction;
        this.next = null;
        this.prev = null;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setNext(AccountNode next) {
        this.next = next;
    }

    public AccountNode getNext() {
        return next;
    }

    public void setPrev(AccountNode prev) {
        this.prev = prev;
    }

    public AccountNode getPrev() {
        return prev;
    }

}