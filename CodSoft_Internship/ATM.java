import java.util.Scanner;

class BankAccount {
	private int balance;

 public BankAccount(int initialBalance) {
     this.balance = initialBalance;
 }

 public synchronized int getBalance() {
     return balance;
 }

 public synchronized void deposit(int amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount + ". Updated balance: " + balance);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public synchronized void withdraw(int amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrew: " + amount + ". Updated balance: " + balance);
     } else {
         System.out.println(amount > balance ? "Insufficient balance. Withdrawal failed." : "Invalid withdrawal amount.");
     }
 }
}




class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void start() {
     Scanner scanner = new Scanner(System.in);

     while (true) {
         displayMenu();
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();

         if (choice == 4) {
             System.out.println("Thank you for using the ATM. Goodbye!");
             break;
         }

         if (choice == 1) {
             System.out.print("Enter amount to withdraw: ");
             account.withdraw(scanner.nextInt());
         } else if (choice == 2) {
             System.out.print("Enter amount to deposit: ");
             account.deposit(scanner.nextInt());
         } else if (choice == 3) {
             System.out.println("Current balance: " + account.getBalance());
         } else {
             System.out.println("Invalid choice. Please try again.");
         }
     }

     scanner.close();
 }

 private void displayMenu() {
     System.out.println("\n--- ATM Menu ---");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }
}


public class ATMMachine {
 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000); 
     ATM atm = new ATM(account);
     atm.start();
 }
}