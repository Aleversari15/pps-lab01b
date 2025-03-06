package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest{
    @BeforeEach
    void init(){
        this.account = new BronzeBankAccount(new CoreBankAccount(),1);
    }

    @Test
    public void testCanWithdrawWithoutFeeApplication() {
        int withdrawPermittedAmount = 80;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount), this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFeeApplication() {
        int withdrawPermittedAmount = 150;
        int withdrawalFee = 1;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount + withdrawalFee), this.account.getBalance());
    }

    @Test
    public void testCannotWithdraw(){
        int withdrawDeniedAmount = 1100;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawDeniedAmount));
    }
}
