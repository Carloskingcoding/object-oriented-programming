/*
The Operation abstract class declares two abstract methods: undo() and redo(), which must be implemented by the subclass.
The undo() method encapsulates the logic to reverse the effects of a previously executed operation,
In the other hand, the redo() method defines the steps required to reapply operations, allowing the system to return to the state 
it was in after the operation was first performed.

By defining these abstract methods, the Operation class defines a standard interface for
handles undo and redo functions, facilitating the implementation of various types of operations
 */
abstract class Operation {
    abstract void undo();
    abstract void redo();
}
