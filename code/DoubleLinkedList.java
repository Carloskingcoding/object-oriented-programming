/*
The DoubleLinkedList class manages a customized doubly linked list structure for storing AccountNode elements,
provides important functionality for node insertion and swapping. It maintains references to the head and
tail node of the list to facilitate efficient traversal and manipulation.

In the insert(Account account) method, a new AccountNode containing the provided Account object is added to the end of the list.
If the list is empty, the new nodes become head and tail; otherwise it will be added after the current tail node,
and the tail reference is updated accordingly.

The swapNodes(AccountNode node1, AccountNode node2) method allows swapping positions between two specified nodes
in the list. This ensures that connections between neighboring nodes are properly updated after a swap operation,
maintain the integrity of the doubly linked list structure.

Accessor and mutator methods (getHead(), setHead()) are provided to retrieve and change the head node of a linked list,
facilitates external manipulation of the list structure.

Overall, the DoubleLinkedList class serves as a powerful tool for managing lists of doubly linked account nodes,
offers essential functionality for insertion, node swapping, and list traversal.
 */

 public class DoubleLinkedList {
    private AccountNode head;
    private AccountNode tail;
    

    public void insert(Account account) {
        AccountNode newNode = new AccountNode(account);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void swapNodes(AccountNode node1, AccountNode node2) {
        if (node1 == null || node2 == null) {
            throw new IllegalArgumentException("Nodes cannot be null");
        }

        if (node1 == node2) {
            return; 
        }

        AccountNode tempNext = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(tempNext);

        AccountNode tempPrev = node1.getPrev();
        node1.setPrev(node2.getPrev());
        node2.setPrev(tempPrev);

        if (node1.getNext() != null) {
            node1.getNext().setPrev(node1);
        } else {
            tail = node1; 
        }

        if (node2.getNext() != null) {
            node2.getNext().setPrev(node2);
        } else {
            tail = node2; 
        }

        if (node1.getPrev() != null) {
            node1.getPrev().setNext(node1);
        } else {
            head = node1; 
        }

        if (node2.getPrev() != null) {
            node2.getPrev().setNext(node2);
        } else {
            head = node2; 
        }
    }

    public AccountNode getHead() {
        return head;
    }

    public void setHead(AccountNode head) {
        this.head = head;
    }

    public void removeFromFront(AccountNode nodeToRemove) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (head == nodeToRemove) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            if (tail == nodeToRemove) {
                tail = null; 
            }
            return;
        }

        AccountNode prevNode = nodeToRemove.getPrev();
        AccountNode nextNode = nodeToRemove.getNext();

        if (prevNode != null) {
            prevNode.setNext(nextNode);
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        } else {
            tail = prevNode;
        }

        nodeToRemove.setPrev(null);
        nodeToRemove.setNext(null);
    }

    public void addToFront(AccountNode newAccountNode) {
        if (head == null) {
            head = newAccountNode;
            tail = newAccountNode;
            return;
        }

        newAccountNode.setNext(head);
        head.setPrev(newAccountNode);
        head = newAccountNode;
    }

    public void remove(Transaction lastTransaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
