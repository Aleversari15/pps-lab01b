package e1;

public class GoldBankAccount implements BankAccount{
    private static final int MAX_OVERDRAFT = -500;
    private final BankAccount base;

    public GoldBankAccount(BankAccount bankAccount){
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
        if(this.base.getBalance() - amount < MAX_OVERDRAFT){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
