import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;


public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");
        // Additional banking system logic would go here
        Map<String,Account> accountsList = new LinkedHashMap<>();
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
                    accountID = BankingService.getAccountID();
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
