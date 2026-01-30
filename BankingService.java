import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collector;

public class BankingService {
    Map<String,Account> accountsList = new HashMap<>();
    String accountID = null; Account acc = null; double amount;
    private static MonotonicCounter counter = new MonotonicCounter();
    private static String accountIDGenerate(){
        return "ACC" + String.format("%09d", counter.next());
    }
    public static String getAccountID(){
        return accountIDGenerate();
    }
    public Map<String, Account> deposited(String accountID, double amount){ 
        acc = accountsList.get(accountID);
        if(acc != null){
            acc.deposit(amount);
            System.out.println("Deposit successful to account: " + accountID);
        }
        else{
            System.out.println("Account not found.");
        }
        return accountsList;
    }
}
