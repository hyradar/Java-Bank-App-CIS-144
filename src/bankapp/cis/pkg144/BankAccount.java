package bankapp.cis.pkg144;

public class BankAccount {
    
    final private String accountOwner;
    private double balance;
    
    public BankAccount(String newOwner, double newBalance) {
        this.accountOwner = newOwner;
        this.balance = newBalance;
    }
    
    public BankAccount(String owner) {
        this.accountOwner = owner;
    }
    
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public String getName() {
        return this.accountOwner;
    }
    
    public void Withdraw (double widthrawAmount) {
          this.balance -= widthrawAmount; 
    }
    
    public void Deposit (double depositAmount) {
        this.balance += depositAmount;
    }
    
    public boolean verifyMoneyIsWithdrawable(double withdrawAmount) {
        return this.balance >= withdrawAmount;
    }
    
    public boolean verifyMoneyIsDepositable(double depositAmount) {
        return depositAmount < 1000;
    }   
}