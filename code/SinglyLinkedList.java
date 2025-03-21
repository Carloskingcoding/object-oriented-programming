/*
The SinglyLinkedList class acts as a fundamental tool for organizing a singly linked list structure, primarily tailored to 
accommodate AccountNode elements. Central to its functionality is the management of the list's structure and the manipulation of its nodes.
At its core, the class maintains a crucial reference to the head of the list (head). The insert(Account transaction) 
method orchestrates the addition of a new AccountNode, incorporating the provided Account object into the list. If the list is empty, 
the new node assumes the role of the head; otherwise, it traverses the list until reaching the end, where it appends the new node.
Additionally, the swapNodes(AccountNode node1, AccountNode node2) method empowers users to rearrange the positions of 
two specified nodes within the list. This process ensures the seamless transition of connections between neighboring nodes, 
thus preserving the integrity of the list's structure.
Facilitating external interactions with the list, the class offers accessor and mutator methods (getHead(), setHead()) 
dedicated to retrieving and modifying the head node. These methods grant users the ability to manipulate the list structure 
from outside the class, enhancing its versatility and usability.
In summary, the SinglyLinkedList class serves as a cornerstone for managing a singly linked list of account nodes, 
delivering crucial functionalities such as node insertion and position swapping. Its intuitive design and robust capabilities 
contribute to efficient list management within a software environment.
 */
public class SinglyLinkedList {
    private AccountNode head;

    public void insert(Account transaction) {
        AccountNode newNode = new AccountNode(transaction);
        if (head == null) {
            head = newNode;
        } else {
            AccountNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void swapNodes(AccountNode node1, AccountNode node2) {
        if (node1 == null || node2 == null) {
            throw new IllegalArgumentException("Nodes cannot be null");
        }

        AccountNode tempPrev = node1.getPrev();
        AccountNode tempNext = node1.getNext();

        node1.setPrev(node2.getPrev());
        node1.setNext(node2.getNext());

        node2.setPrev(tempPrev);
        node2.setNext(tempNext);

        if (node1.getPrev() != null) {
            node1.getPrev().setNext(node1);
        } else {
            head = node1;
        }

        if (node1.getNext() != null) {
            node1.getNext().setPrev(node1);
        }

        if (node2.getPrev() != null) {
            node2.getPrev().setNext(node2);
        } else {
            head = node2;
        }

        if (node2.getNext() != null) {
            node2.getNext().setPrev(node2);
        }
    }

    public AccountNode getHead() {
        return head;
    }

    public void setHead(AccountNode head) {
        this.head = head;
    }

}
