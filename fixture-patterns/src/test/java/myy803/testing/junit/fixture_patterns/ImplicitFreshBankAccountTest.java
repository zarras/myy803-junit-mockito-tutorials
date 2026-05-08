package myy803.testing.junit.fixture_patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImplicitFreshBankAccountTest {

    private BankAccount account;

    // 🔁 fresh fixture before each test
    @BeforeEach
    void setUp() {
        account = new BankAccount("John", 1000);
    }

    @Test
    void initialBalanceIsCorrect() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    void depositIncreasesBalance() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void withdrawTooMuchThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(2000);
        });
    }

    @Test
    void invalidDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }
}
