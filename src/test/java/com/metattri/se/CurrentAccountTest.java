package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {
    private CurrentAccount account;

    @BeforeEach
    public void setUp() {
        account = new CurrentAccount("002", "Mary");
        account.deposit(500);
    }

    @Test
    public void testWithdrawWithinBalanceAndOverdraftLimit() {
        assertTrue(account.withdraw(600.0));
        assertEquals(-100.0, account.getBalance());
    }

    @Test
    public void testWithdrawOverBalanceAndOverdraftLimit() {
        assertFalse(account.withdraw(1000.1));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void testGetOverdraftLimit() {
        assertEquals(500.0, account.getOverdraftLimit());
    }

    @Test
    public void testSetOverdraftLimit() {
        account.setOverdraftLimit(2000.0);
        assertEquals(2000.0, account.getOverdraftLimit());
    }

    @Test
    public void testToString() {
        String expected = """
                Account number: 002
                Account type: CurrentAccount
                Account name: Mary
                Balance: 500.0""";
        assertEquals(expected, account.toString());
    }
}