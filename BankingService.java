import java.util.HashMap;
import java.util.stream.Collector;

public class BankingService {
    private static MonotonicCounter counter = new MonotonicCounter();
    private static String accountIDGenerate(){
        return "ACC" + String.format("%09d", counter.next());
    }
    public static String getAccountID(){
        return accountIDGenerate();
    }
}
