/*
The DebitCard class inherits from the Account class, extending its functionalities to represent a debit card account 
within the banking system. It introduces an additional attribute, dailyWithdrawalLimit, representing the maximum amount that 
can be withdrawn from the account in a single day.
In the constructor method DebitCard(), it initializes the debit card account with specific details including account number, 
account holder name, balance, daily withdrawal limit, username, and password. It invokes the superclass constructor super() 
to initialize inherited attributes from the Account class.
The addTransaction() method overrides the superclass method to allow adding transactions specific to the debit card account.
The displayAccountDetails() method overrides the superclass method to provide detailed information about the debit card account, 
including account number, account holder name, balance, and daily withdrawal limit.
The withdraw() method enables withdrawing funds from the debit card account. It checks if the withdrawal amount exceeds the 
available balance or the daily withdrawal limit and provides appropriate feedback to the user regarding the success or 
failure of the withdrawal operation.
Overall, the DebitCard class encapsulates the functionality specific to debit card accounts, ensuring accurate
 management of transactions and adherence to daily withdrawal limits.
 */

public class DebitCard extends Account {
    protected double dailyWithdrawalLimit;

    public DebitCard(String accountNumber, String accountHolderName, double balance, double dailyWithdrawalLimit,String username, String password) {
        super(accountNumber, accountHolderName, balance, username, password);
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;

    }

    @Override
    public void addTransaction(Transaction transaction) {
        super.addTransaction(transaction);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Debit Card Details");
        System.out.println("Account Number   : " + accountNumber);
        System.out.println("Account Name     : " + accountHolderName);
        System.out.println("Balance          : $ " + balance);
        System.out.println("Withdrawal Limit : $ " + dailyWithdrawalLimit + "/Days");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("INSUFFICIENT FUNDS FOR WITHDRAWAL");
        }
        else if (amount > dailyWithdrawalLimit) {
            System.out.println("Withdrawal amount exceeds the daily withdrawal limit");
        } else {
            System.out.println("\nWithdrawal successful");
            System.out.println("New balance : $  "+ balance);
        }
    }
}



