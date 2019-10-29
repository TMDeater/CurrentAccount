package model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CurrentAccountTest {
    @Test
    public void testCurrentAccount() {
        CurrentAccount ca = new CurrentAccount("00001", BigDecimal.valueOf(100.03), "Cust Name");
        Assert.assertEquals("00001", ca.getId());
        Assert.assertEquals(BigDecimal.valueOf(100.03), ca.getBalance());
        Assert.assertEquals("Cust Name", ca.getCustomerName());
    }
}