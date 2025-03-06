package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount(),1);
    }

    @Test
    public void testCanWithdraw() {
        int withdrawPermittedAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawPermittedAmount);
        assertEquals(DEPOSIT_AMOUNT-(withdrawPermittedAmount+1), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int withdrawDeniedAmount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawDeniedAmount));
    }
}
