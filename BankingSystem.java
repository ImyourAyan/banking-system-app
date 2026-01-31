import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System!");
        // Additional banking system logic would go here
        Scanner sc = new Scanner(System.in);
        BankingService bankingService = new BankingService();
        String accountID = null; double amount;
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
                    bankingService.deposited(accountID, amount);
                    break;
                    
                case 2:
                    System.out.println("Enter Account ID:");
                    accountID = sc.next();
                    System.out.println("Enter amount to withdraw:");
                    amount = sc.nextDouble();
                    bankingService.withdrawn(accountID, amount);
                    break;
                case 3:
                    System.out.println("Enter Account ID:");
                    accountID = sc.next();
                    bankingService.checkbalance(accountID);
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
                    bankingService.createAccount( accountHolderName, initialBalance, Account.AccountStatus.ACTIVE);
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
