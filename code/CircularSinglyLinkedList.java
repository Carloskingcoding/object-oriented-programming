/*
The CircularSinglyLinkedList class manages a circular singly linked list structure for storing Account elements. 
It provides functionalities for insertion, searching, and display operations on the list.

In the insert(Account account) method, a new AccountNode containing the provided Account object is added to the list. 
If the list is empty, the new node becomes the head, and its next reference points back to itself, creating a circular structure. 
Otherwise, it traverses the list to find the last node and then appends the new node, ensuring that the circular connection is maintained.

The search(String query) method enables searching for a specific account within the list based on either the account number 
or username provided in the query. It iterates through the list, examining each node's account details until a match is found, 
returning the corresponding account if found, or null otherwise.

The display() method facilitates the display of all accounts stored in the list. 
It traverses the circular list, printing each account's account number and account holder name until it reaches the head node again, 
ensuring that all elements in the circular list are displayed.

Overall, the CircularSinglyLinkedList class offers essential functionalities for managing a circular singly linked list 
of account nodes, facilitating efficient insertion, searching, and display operations on the list.
 */

 public class CircularSinglyLinkedList {
    private AccountNode head;

    public void insert(Account account) {
        AccountNode newNode = new AccountNode(account);

        if (head == null) {
            head = newNode;
            newNode.setNext(head); 
        } else {
            AccountNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head); 
        }
    }

    public Account search(String query) {
        if (head == null) {
            return null;
        }

        AccountNode current = head;
        do {
            if (current.getAccount().getAccountNumber().equals(query)|| current.getAccount().getUsername().equals(query)) {
                return current.getAccount();
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("EMPTY");
            return;
        }

        AccountNode current = head;
        do {
            System.out.println(
                    current.getAccount().getAccountNumber() + " - " + current.getAccount().getAccountHolderName());
            current = current.getNext();
        } while (current != head);
    }

}

