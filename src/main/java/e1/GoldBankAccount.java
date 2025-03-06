package e1;

public class GoldBankAccount extends BankAccountDecorator{
    private static final int MAX_OVERDRAFT = -500;

    public GoldBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (base.getBalance() - amount < MAX_OVERDRAFT) {
            throw new IllegalStateException("Overdraft limit exceeded");
        }
        base.withdraw(amount);
    }
}
