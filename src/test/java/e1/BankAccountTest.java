package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    protected static final int DEPOSIT_AMOUNT = 1000;
    protected final static int INITIAL_AMOUNT = 0;
    protected BankAccount account;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }
}
