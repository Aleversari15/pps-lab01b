package e1;

public class BronzeBankAccount implements BankAccount{
    private final BankAccount base;
    private final int withdrawalFee = 1;
    private final int limitForFeeApplication = 100;

    public BronzeBankAccount(BankAccount bankAccount){
        this.base = bankAccount;
    }
    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(amount > this.base.getBalance()){
            throw new IllegalStateException();
        }
        this.base.withdraw((amount > limitForFeeApplication) ? amount+withdrawalFee : amount);
    }
}
