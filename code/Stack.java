/*
The Stack class represents a last-in-first-out (LIFO) data structure, where elements are added and removed from the top.
 
It contains a private inner class Node, which serves as the building block for elements stored in the stack.
The class features methods to manipulate the stack: push(Operation operation) adds a new Node containing 
the provided Operation object to the top of the stack, pop() removes and returns the top Operation from the stack, 
isEmpty() checks if the stack is empty, and clear() removes all elements from the stack.

In the Node inner class, each node contains an operation attribute representing the operation to be stored and 
a reference next pointing to the next node in the stack.

Overall, the Stack class provides a simple and efficient way to manage a collection of operations, 
with methods for adding, removing, and checking the status of elements in the stack.
 */

public class Stack {
    private Node top;

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        Node temp = top;
        top = top.next;
        return temp.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }

    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }
}
