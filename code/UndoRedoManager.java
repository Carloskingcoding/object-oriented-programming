/*
The UndoRedoManager class is designed to manage undo and redo operations within a software application. 
It contains two stacks: undoStack for storing operations that have been performed and can be undone, and 
redoStack for storing operations that have been undone and can be redone. Upon instantiation, 

the UndoRedoManager initializes the undoStack and redoStack as empty stacks. The addToUndo method allows adding an operation 
to the undoStack. When an operation is added, the redoStack is cleared, as adding a new operation invalidates any previously undone operations. 

The undo method allows undoing the last operation performed. If the undoStack is not empty, the last operation is popped from the stack, 
its undo method is called to revert its effects, and the operation is pushed onto the redoStack to allow redoing it if needed. 
If the undoStack is empty, a message "Nothing to undo" is printed. 

Similarly, the redo method allows redoing the last undone operation. If the redoStack is not empty, the last undone operation is popped from the stack,
its redo method is called to reapply its effects, and the operation is pushed onto the undoStack to allow undoing it again if needed. 
If the redoStack is empty, a message "Nothing to redo" is printed. 

Overall, the UndoRedoManager class provides essential functionality for
 managing undo and redo operations in an application, enhancing user experience and interaction.
 */
import java.util.Stack;

public class UndoRedoManager {
    private Stack<Transaction> undoStack;
    private Stack<Transaction> redoStack;
    private DoubleLinkedList transactionHistory;
    

    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        transactionHistory = new DoubleLinkedList();
    }

    public void addToUndo(Transaction transaction) {
        undoStack.push(transaction);
        redoStack.clear();
    }

    public void UndoRedoDeposit() {
        this.transactionHistory = new DoubleLinkedList();
    }

    public void addDeposit(Account transaction) {
        transactionHistory.insert(transaction);
    }


    public void undoDepositTransaction() {
        if (!undoStack.isEmpty()) {
            Transaction lastTransaction = undoStack.pop();
            if (lastTransaction.getType().equals("Deposit")) {
                Account account = getAccountByNumber(lastTransaction.getAccountNumber());
                if (account != null) {
                    double amount = lastTransaction.getAmount();
                    account.setBalance(account.getBalance() - amount);
                    System.out.println("Deposit of : " + amount + ", New Balance : " + account.getBalance());
                    account.removeTransaction(lastTransaction);
                    transactionHistory.remove(lastTransaction);
                } else {
                    System.out.println("Account not found");
                }
            } else {
                System.out.println("Last transaction was not a Deposit");
            }
        } else {
            System.out.println("No transactions");
        }
    }

    public void undoWithdrawalTransaction() {
        if (!undoStack.isEmpty()) {
            Transaction lastTransaction = undoStack.pop();
            if (lastTransaction.getType().equals("Withdrawal")) {
                Account account = getAccountByNumber(lastTransaction.getAccountNumber());
                if (account != null) {
                    double amount = lastTransaction.getAmount();
                    account.setBalance(account.getBalance() + amount);
                    System.out.println("Undid Withdrawal of: " + amount + ", New Balance: " + account.getBalance());
                    account.removeTransaction(lastTransaction);
                    transactionHistory.remove(lastTransaction);
                } else {
                    System.out.println("Account not found.");
                }
            } else {
                System.out.println("Last transaction was not a Withdrawal");
            }
        } else {
            System.out.println("No transactions");
        }
    }

    private Account getAccountByNumber(String accountNumber) {
        return null;
    }
}   