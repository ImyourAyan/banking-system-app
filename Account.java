
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

public class Account{
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