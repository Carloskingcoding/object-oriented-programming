/*
The Main class functions as the main component of the banking system, functions for user interaction and
operation. It encapsulates functionality for user authentication, account management,transaction processing, 
and retrieval of transaction history.

The login() method facilitates user authentication by requiring username and password input.
It verifies the credentials against an existing account using the login() method operating on the CircularDoublyLinkedList account.
After successful authentication, it assigns CurrentAccount to the authenticated account.

The signup() method guides users through the process of creating a new account, asking for personal information such as name,
username and password. It validates the password to ensure it meets the specified criteria and adds the new account to the account list.

Transaction related methods such as Deposit() and Withdraw() handle deposit and withdrawal operations respectively,
update account balances and transaction history as appropriate. This method ensures that transactions are processed securely
and accurate, taking into account factors such as available balance and transaction limits.

Methods for viewing transaction history (viewTransactionHistoryByDateAndAccount(), DepositTransactions(), WithdrawalTransactions()) 
allows users to review past transactions, providing detailed information such as transaction codes, type, quantity, and date.

The searchAccount() method allows users to search for a specific account by name or account number, displaying account details if found.
This improves user experience by facilitating easy access to relevant account information.

Overall, the Main class manages the core functions of the banking system, making a safe and efficient management of user accounts and transactions.
 */

 import java.time.LocalDate;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 import java.util.UUID;
 
 public class Main {
 
     private static DoubleLinkedList depositList = new DoubleLinkedList();
     private static SinglyLinkedList withdrawalList = new SinglyLinkedList();
     private static CircularSinglyLinkedList question = new CircularSinglyLinkedList();
     private static CircularDoublyLinkedList accountList = new CircularDoublyLinkedList();
     private static UndoRedoManager undoRedoManager = new UndoRedoManager();
     private static Scanner scanner = new Scanner(System.in);
     private static Account currentAccount;
 
     public static void main(String[] args) {
         boolean isLoggedIn = false;
         boolean isSignedUp = false;
         int CHOICE;
 
         while (!isLoggedIn) {
             System.out.println("WELCOME TO MECH BANK");
             System.out.println("1. LOGIN");
             System.out.println("2. SIGNUP");
             System.out.println("3. KELUAR");
             System.out.print("CHOICE : ");
             int choice = scanner.nextInt();
             switch (choice) {
                 case 1:
                     isLoggedIn = login();
                     break;
                 case 2:
                     isSignedUp = Signup();
                     break;
                 case 3:
                     System.out.println("THANK YOU FOR USING MECH BANK");
                     return;
                 default:
                     System.out.println("INVALID");
             }
 
             if (isSignedUp) {
                 System.out.println("SIGN UP WAS SUCCESSFUL, PLEASE LOGIN TO MAKE A TRANSACTION\n");
             }
         }
 
         while(true) {
             System.out.println("\nWELCOME TO MECH BANK");
             System.out.println("1. SHOW ACCOUNT DETAIL");
             System.out.println("2. DEPOSIT");
             System.out.println("3. WITHDRAW");
             System.out.println("4. CANCEL TRANSACTION");
             System.out.println("5. TRANSACTION HISTORY");
             System.out.println("6. FIND ANOTHER ACCOUNT");
             System.out.println("7. ASK QUESTIONS");
             System.out.println("8. EXIT");
             System.out.print("CHOICE : ");
             CHOICE = scanner.nextInt();
 
             switch (CHOICE) {
                 case 1:
                     ViewAccount(currentAccount);
                     break;
                 case 2:
                     Deposit(currentAccount, depositList);
                     break;
                 case 3:
                     Withdrawal(currentAccount, withdrawalList);
                     break;
                 case 4:
                     int CHOICE4;
                     do {
                         System.out.println("1. DEPOSIT");
                         System.out.println("2. WITHDRAW");
                         System.out.println("3. BACK");
                         System.out.print("CHOICE : ");
                         CHOICE4 = scanner.nextInt();
                         switch (CHOICE4) {
                             case 1:
                                 System.out.println("DEPOSIT");
                                 undoRedoManager.undoDepositTransaction();
                                 break;
 
                             case 2:
                                 System.out.println("WITHDRAW");
                                 undoRedoManager.undoWithdrawalTransaction();
                                 break;
 
                             case 3:
                                 break;
                             default:
                                 System.out.println("INVALID");
                         }
                     } while (CHOICE4 != 3);
                     break;

                 case 5:
                 int CHOICE6 ;
                     do{
                         System.out.println("1. DEPOSIT");
                         System.out.println("2. WITHDRAW");
                         System.out.println("3. ALL");
                         System.out.println("4. BACK");
                         System.out.print("CHOICE : ");
                         CHOICE6 = scanner.nextInt();
                         switch (CHOICE6) {
                             case 1:
                                 System.out.println("DEPOSIT TRANSACTION HISTORY");
                                 DepositTransactions(currentAccount);
                                 break;
 
                             case 2:
                                 System.out.println("WITHDRAW TRANSACTION HISTORY");
                                 WithdrawalTransactions(currentAccount);
                                 break;
 
                             case 3:
                                 System.out.println("DEPOSIT AND WITHDRAW TRANSACTION HISTORY ");
                                 ViewTransactionHistory(currentAccount);
                                 break;
 
                             case 4:
                                 break;
                                 
 
                             default:
                                 System.out.println("INVALID");
                         }
 
                     }while(CHOICE6 != 4);
                     break;
 
                 case 6:
                     FindAccount();
                     break;
                 
                 case 7:
                     AskQuestions(question);
                     break;
 
                 case 8:
                     System.out.println("THANK YOU FOR USING MECH BANK");
                     System.exit(0);
                     break;
                 default:
                     System.out.println("INVALID");
             }
         }
     }
 
     public static boolean login() {
         System.out.print("USERNAME : ");
         String usernameInput = scanner.next();
         System.out.print("PASSWORD : ");
         String passwordInput = scanner.next();
 
         currentAccount = login(accountList, usernameInput, passwordInput);
         if (currentAccount != null) {
             System.out.println("LOGIN SUCCESSFUL");
             return true;
         } else {
             System.out.println("LOGIN FAIL");
             return false;
         }
     }
 
     public static Account login(CircularDoublyLinkedList accountList, String username, String password) {
         if (accountList == null || username == null || password == null) {
             throw new IllegalArgumentException("INVALID INPUT");
         }
         AccountNode head = accountList.getHead();
         if (head == null) {
             return null; 
         }
 
         AccountNode current = head;
         do {
             if (current.getAccount().getUsername().equalsIgnoreCase(username)&& current.getAccount().getPassword().equals(password)) {
                 return current.getAccount(); 
             }
             current = current.getNext();
         } while (current != accountList.getHead());
 
         return null; 
     }
 
     public static boolean Signup() {
         System.out.println("\nPLEASE ENTER YOUR PERSONAL INFORMATION TO SIGN UP");
 
         System.out.print("NAME : ");
         String accountHolderName = scanner.next();
 
         System.out.print("USERNAME : ");
         String username = scanner.next();
 
         String password;
         boolean isValidPassword;
         do {
             System.out.print("PASSWORD : ");
             password = scanner.next();
             isValidPassword = ValidatePassword(password);
                 if (!isValidPassword) {
                     System.out.println("PASSWORD MUST CONTAIN LETTERS AND NUMBERS");
                     System.out.println("        FOR EXAMPLE (qwerty123)");
                 }
         } while (!isValidPassword);
 
         System.out.print("ENTER BALANCE FOR DEBIT $ ");
         double initialBalanceDebit = scanner.nextDouble();
 
         System.out.print("ENTER LIMIT WITHDRAWAL FOR DEBIT $ ");
         double dailyWithdrawalLimit = scanner.nextDouble();
 
         accountList.add(new DebitCard(generateAccountNumber(), accountHolderName,initialBalanceDebit,dailyWithdrawalLimit,username, password));
         
         return true;
     }
 
     private static boolean ValidatePassword(String password) {
         boolean hasLetter = false;
             for (int i = 0; i < password.length(); i++) {
                 char c = password.charAt(i);
                 if (Character.isLetter(c)) {
                     hasLetter = true;
                     break;
                 }
             }
         boolean hasDigit = false;
             for (int i = 0; i < password.length(); i++) {
                 char c = password.charAt(i);
                 if (Character.isDigit(c)) {
                     hasDigit = true;
                     break;
                 }
             }
         return hasLetter && hasDigit && password.length() >= 6;
     }
 
     public static void ViewAccount(Account account) {
         if (account != null) {
             account.displayAccountDetails();
             System.out.println();
         } else {
             System.out.println("PLEASE LOG IN");
         }
     }
 
     public static void Deposit(Account account, DoubleLinkedList depositList) {
         if (account != null) {
             System.out.print("DEPOSIT AMOUNT $ ");
             double jumlahSetor = scanner.nextDouble();
             scanner.nextLine();
 
             if (jumlahSetor <= 0) {
                 System.out.println("DEPOSIT MUST BE GREATER THAN 0");
                 return;
             }
 
             account.setBalance(account.getBalance() + jumlahSetor);
             System.out.println("==== DEPOSIT SUCCESSFUL ====");
             System.out.println("( New balance $ " + account.getBalance() + " )");
             Transaction depositTransaction = new Transaction("Deposit", jumlahSetor, LocalDate.now(),account.getAccountNumber());
             account.addTransaction(depositTransaction);
 
         } else {
             System.out.println("INVALID");
         }
     }
 
     public static void Withdrawal(Account account, SinglyLinkedList withdrawalList) {
         if (account != null && account instanceof DebitCard) {
             DebitCard debitCard = (DebitCard) account;
             System.out.print("WITHDRAWAL AMOUNT $ ");
             double jumlahTarik = scanner.nextDouble();
             double saldoSebelumTarik = debitCard.getBalance();
 
             if (jumlahTarik <= saldoSebelumTarik) {
                 double saldoSetelahTarik = saldoSebelumTarik - jumlahTarik;
                 debitCard.setBalance(saldoSetelahTarik);
                 System.out.println("==== WITHDRAWAL SUCCESSFUL ====");
                 System.out.println("( Remaining balance $ " + saldoSetelahTarik + " )");
                 Transaction withdrawalTransaction = new Transaction("Withdrawal", jumlahTarik, LocalDate.now(),
                         account.getAccountNumber());
                 account.addTransaction(withdrawalTransaction);
             } else {
                 System.out.println("INVALID , Please double check your transaction");
             }
         }
     }
 
     public static void ViewTransactionHistory(Account account1) {
         AccountNode current = accountList.getHead();
         if (current == null) {
             System.out.println("No accounts available");
             return;
         }
 
         do {
             Account account = (Account) current.getAccount();
             System.out.println("------------------------------");
             System.out.println("Account Number : " + account.getAccountNumber());
             System.out.println("------------------------------");
             List<Transaction> transactionHistory = account.getTransactionHistory();
             if (transactionHistory != null && !transactionHistory.isEmpty()) {
                 for (Transaction transaction : transactionHistory) {
                     System.out.println("Transaction Code : " + generateTransactionCode(transaction));
                     System.out.println("Type             : " + transaction.getType());
                     System.out.println("Amount           $ " + transaction.getAmount());
                     System.out.println("Date             : " + transaction.getDate());
                     System.out.println("--------------------------");
                 }
             } else {
                 System.out.println("No transaction history available.");
             }
             current = current.getNext();
         } while (current != accountList.getHead());
     }
 
     public static void FindAccount() {
         System.out.print("Masukkan nama atau nomor rekening : ");
         String query = scanner.next();
         Account foundAccount = accountList.search(query);
         if (foundAccount != null) {
             System.out.println("Account ditemukan : ");
             foundAccount.displayAccountDetails();
         } else {
             System.out.println("ACCOUNT NOT FOUND");
         }
     }
 
     public static void DepositTransactions(Account account) {
         List<Transaction> transactionHistory = account.getTransactionHistory(); 
         ArrayList<Transaction> depositTransactionsList = new ArrayList<>();
         int countDepositTransactions = 0;
 
         for (Transaction transaction : transactionHistory) {
             if (transaction.getAmount() > 0 && transaction.getType().equals("Deposit")) {
                 depositTransactionsList.add(transaction);
                 countDepositTransactions++;
             }
         }
 
         System.out.println("------------------------------");
         System.out.println("Account Number : " + account.getAccountNumber());
         System.out.println("------------------------------");
 
         if (countDepositTransactions > 0) {
             for (Transaction transaction : depositTransactionsList) {
                 System.out.println("Transaction Code : " + generateTransactionCode(transaction));
                 System.out.println("Type             : Deposit");
                 System.out.println("Amount           $ " + transaction.getAmount());
                 System.out.println("Date             : " + transaction.getDate());
                 System.out.println("--------------------------");
             }
         } else {
             System.out.println("No Deposit transactions available.");
         }
     }
 
     public static void WithdrawalTransactions(Account account) {
         List<Transaction> transactionHistory = account.getTransactionHistory(); 
         ArrayList<Transaction> withdrawalTransactionsList = new ArrayList<>();
         int countWithdrawalTransactions = 0;
 
         for (Transaction transaction : transactionHistory) {
             if (transaction.getAmount() > 0 && transaction.getType().equals("Withdrawal")) {
                 withdrawalTransactionsList.add(transaction);
                 countWithdrawalTransactions++;
             }
         }
 
         System.out.println("------------------------------");
         System.out.println("Account Number : " + account.getAccountNumber());
         System.out.println("------------------------------");
 
         if (countWithdrawalTransactions > 0) {
             for (Transaction transaction : withdrawalTransactionsList) {
                 System.out.println("Transaction Code : " + generateTransactionCode(transaction));
                 System.out.println("Type             : Withdrawal");
                 System.out.println("Amount           $ " + transaction.getAmount());
                 System.out.println("Date             : " + transaction.getDate());
                 System.out.println("--------------------------");
             }
         } else {
             System.out.println("No withdrawal transactions available.");
         }
     }
 
     public static void AskQuestions(CircularSinglyLinkedList questionsList) {
         Scanner scanner = new Scanner(System.in);
         char choice = 'Y';
 
         while (choice == 'Y') {
             System.out.println("Enter your question:");
             String questionText = scanner.next();
             System.out.println("Question submitted successfully.");
             choice = scanner.nextLine().toUpperCase().charAt(0);
         }
 
         scanner.close();
     }
     
     private static String generateTransactionCode(Transaction transaction) {
         String uniqueCode = UUID.randomUUID().toString().substring(0, 8);
         return uniqueCode + " - " + transaction.getType() + " - " + transaction.getDate();
     }
 
     private static String generateAccountNumber() {
         return "AC_" + (int) (Math.random() * 100000);
     }
 }