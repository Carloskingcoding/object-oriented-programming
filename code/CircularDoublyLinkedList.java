/*
The CircularDoublyLinkedList class manages a circular doubly linked list structure. It facilitates adding 
new accounts to the list while maintaining circular connections between nodes. 
When adding an account, it creates a new node containing the account information and appropriately updates the links to ensure circularity. 
Additionally, it provides functionality to search for an account based on either the account number or username, 
traversing the list in a circular manner until a match is found. The class also supports displaying the contents of the list, 
iterating through each node and printing the account details. Accessor methods allow retrieving and 
modifying the head node of the list. Overall, the class provides essential operations for managing a circular doubly linked list of accounts.
 */

public class CircularDoublyLinkedList {
    private AccountNode head;


    public void add(Account account) {
        AccountNode newNode = new AccountNode(account);
        
        if (head == null) {
            head = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
        } else {
            AccountNode tail = head.getPrev();
            tail.setNext(newNode);
            newNode.setPrev(tail);
            newNode.setNext(head);
            head.setPrev(newNode);
        }
    }

    public Account search(String query) {
        AccountNode current = head;
        if (current == null) {
            return null;
        }
        do {
            if (current.getAccount().getAccountNumber().equals(query)
                    || current.getAccount().getUsername().equals(query)) {
                return current.getAccount();
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    public void display() {
        AccountNode current = head;
        if (current == null) {
            System.out.println("EMPTY");
        } else {
            do {
                System.out.println(
                        current.getAccount().getAccountNumber() + " - " + current.getAccount().getAccountHolderName());
                current = current.getNext();
            } while (current != head);
        }
    }

    public AccountNode getHead() {
        return head;
    }

    public void setHead(AccountNode head) {
        this.head = head;
    }
}
