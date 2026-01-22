import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

class MonotonicCounter {
    private final AtomicLong value = new AtomicLong(0);

    public long next() {
        return value.incrementAndGet();
    }
}
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

class Account{
    private String accountHolderName;
    private double balance;
    private AccountStatus status;
    enum AccountStatus{
        ACTIVE(1), INACTIVE(0), CLOSED(-1);
        private final int statuscode;
        AccountStatus(int statuscode){
            this.statuscode = statuscode;
        }
        public int getStatuscode(){
            return statuscode;
        }
    }
    
    public Account(String accountHolderName, double balance, AccountStatus status){
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.status = status;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
        else{
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance to withdraw: " + amount);
        }
        balance -= amount;
    }
}

public class BankingSystem {
    private static MonotonicCounter counter = new MonotonicCounter();
    private static String accountIDGenereate(){
        return "ACC" + String.format("%09d", counter.next());
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");
        // Additional banking system logic would go here
        Map<String,Account> accountsList = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String accountID = null; Account acc = null; double amount;
        while(true){
            System.out.println("1.Deposit\n2.Withdraw\n3.Check Balance\n4.Create a Account\n5.Exit");
            int input = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (input) {
                case 1:
                    System.out.println("Enter Account ID:");
                    accountID = sc.next();
                    System.out.println("Enter amount to deposit:");
                    amount = sc.nextDouble();
                    // Account.deposit(amount);
                    acc = accountsList.get(accountID);
                    if(acc != null){
                    acc.deposit(amount);
                    System.out.println("Deposit successful to account: " + accountID);
                    }
                    else{
                        System.out.println("Account not found.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Enter Account ID:");
                    accountID = sc.next();
                    System.out.println("Enter amount to withdraw:");
                    amount = sc.nextDouble();
                    acc = accountsList.get(accountID);
                    if(acc != null){
                        try {
                            acc.withdraw(amount);
                            System.out.println("Withdrawal successful from account: " + accountID);  
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    }
                    else{
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account ID:");
                    accountID = sc.next();
                    acc = accountsList.get(accountID);
                    if(acc != null){
                    System.out.println("Current Balance: " + acc.getBalance());
                    }
                    else{
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.println("Creating a new account...");
                    accountID = accountIDGenereate();
                    System.out.println("Your Account ID: " + accountID); // 1
                    System.out.println("Enter Account Holder Name:");
                    String accountHolderName = sc.nextLine();
                    System.out.println();
                    System.out.println("Enter Initial Balance:");
                    double initialBalance = sc.nextDouble();
                    Account newAccount = new Account(accountHolderName, initialBalance, Account.AccountStatus.ACTIVE);
                    accountsList.put(accountID,newAccount);
                    System.out.println("New account created successfully!");
                    
                    break;
                case 5:
                    System.out.println("Exiting the Banking System. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
