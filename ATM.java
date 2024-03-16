import java.util.Scanner;

// BankAccount class representing the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class representing the ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // Method to handle user choice and perform corresponding actions
    public void handleChoice() {
        while (true) {

        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    // Method to handle withdrawal
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + account.checkBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to handle deposit
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return;
        }
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.checkBalance());
    }

    // Method to handle checking balance
    private void checkBalance() {
        System.out.println("Current balance: " + account.checkBalance());
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        atm.handleChoice();
    }
}
