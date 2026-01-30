import java.util.Map;
import java.util.HashMap;
// import java.util.stream.Collector;

public class BankingService {
    private Map<String,Account> accountsList = new HashMap<>();
    String accountID = null; Account acc = null; double amount, balance;
    private static MonotonicCounter counter = new MonotonicCounter();
    private static String accountIDGenerate(){
        return "ACC" + String.format("%09d", counter.next());
    }
    public static String getAccountID(){
        return accountIDGenerate();
    }
    public double deposited(String accountID, double amount){ 
        acc = accountsList.get(accountID);
        if(acc != null){
            acc.deposit(amount);
            System.out.println("Deposit successful to account: " + accountID);
        }
        else{
            System.out.println("Account not found.");
        }
        return balance;
    }
    public double withdrawn(String accountID, double amount){
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
        return balance;
    }
    public double checkbalance(String accountID){
        acc = accountsList.get(accountID);
            if(acc != null){
            System.out.println("Current Balance: " + acc.getBalance());
            }
            else{
                System.out.println("Account not found.");
            }
            return balance;
    }
    public Map<String,Account> createAccount(String accountHolderName, double initialBalance, Account.AccountStatus status){
        Account newAccount = new Account(accountHolderName, initialBalance, status);
        accountsList.put(accountID,newAccount);
        System.out.println("New account created successfully!\n"+"Account ID: " + accountID + "\tAccount Holder: " + accountHolderName + "\tInitial Balance: " + initialBalance);
        return accountsList;
    }
}
