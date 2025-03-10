package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest{
    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdrawWithPositiveBalance() {
        int withdrawPermittedAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount), this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithNegativeBalance() {
        int withdrawPermittedAmount = 1400;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanOverdraftLimit(){
        int withdrawDeniedAmount = 1600;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawDeniedAmount));
    }
}
