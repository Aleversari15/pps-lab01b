package e1;

public class SilverBankAccount extends BankAccountDecorator {
    private final int withdrawalFee;

    public SilverBankAccount(BankAccount base, int withdrawalFee) {
        super(base);
        this.withdrawalFee = withdrawalFee;
    }

    @Override
    public void withdraw(int amount) {
        if (base.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + withdrawalFee);
    }
}
