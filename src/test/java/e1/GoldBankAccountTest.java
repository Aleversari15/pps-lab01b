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
    public void testCanWithdrawWithPositiveBalance() { //+1000; - 200
        int withdrawPermittedAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount), this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithNegativeBalance() { //+1000; -1400;
        int withdrawPermittedAmount = 1400;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanOverdraftLimit(){ //+1000; -1600
        int withdrawDeniedAmount = 1600;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawDeniedAmount));
    }
}
