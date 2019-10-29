package model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testAccount() {
        Account a = new Account("00001", BigDecimal.valueOf(100.03), "Cust Name");
        Assert.assertEquals("00001", a.getId());
        Assert.assertEquals(BigDecimal.valueOf(100.03), a.getBalance());
        Assert.assertEquals("Cust Name", a.getCustomerName());
    }

    @Test
    public void testAcountSetter() {
        Account a = new Account("00001", BigDecimal.valueOf(100.03), "Cust Name");
        a.setId("00002");
        a.setBalance(BigDecimal.valueOf(-0.02));
        a.setCustomerName("Cust Name 2");
        Assert.assertEquals("00002", a.getId());
        Assert.assertEquals(BigDecimal.valueOf(-0.02), a.getBalance());
        Assert.assertEquals("Cust Name 2", a.getCustomerName());
    }

    @Test
    public void testZeroOrNegativeBalance() {
        Account a = new Account("00001", BigDecimal.valueOf(-0.03), "Cust Name");
        boolean temp = a.isNegativeOrZeroBalance();
        Assert.assertEquals(true, temp);

        a.setBalance(BigDecimal.valueOf(1.22));
        temp = a.isNegativeOrZeroBalance();
        Assert.assertEquals(false, temp);
    }
}