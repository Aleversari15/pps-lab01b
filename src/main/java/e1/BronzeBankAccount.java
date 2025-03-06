package e1;

public class BronzeBankAccount extends BankAccountDecorator{
    private final int withdrawalFee;

    public BronzeBankAccount(BankAccount base, int withdrawalFee) {
        super(base);
        this.withdrawalFee = withdrawalFee;
    }

    @Override
    public void withdraw(int amount) {
        int limitForFeeApplication = 100;
        if (amount > base.getBalance()) {
            throw new IllegalStateException();
        }
        int fee = (amount > limitForFeeApplication) ? withdrawalFee : 0;
        base.withdraw(amount + fee);
    }
}
