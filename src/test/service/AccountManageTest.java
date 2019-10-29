package service;

import model.Account;
import model.CurrentAccount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountManageTest {
    @Test
    public void testAccountManage() {
        AccountManage accountManage = new AccountManage();
    }

    @Test
    public void testAccountManage2() {
        ArrayList<Account> accountList = new ArrayList<>();
        Account ac1 = new Account("00001", BigDecimal.valueOf(1.1), "Customer1");
        CurrentAccount ac2 = new CurrentAccount("00002", BigDecimal.valueOf(1.2), "Customer2");
        accountList.add(ac1);
        accountList.add(ac2);
        AccountManage accountManage = new AccountManage(accountList);
    }

    @Test
    public void testAddGetAccount() {
        AccountManage accountManage = new AccountManage();
        accountManage.AddAccount("00001", BigDecimal.valueOf(1.1), "Customer1");
        accountManage.AddCurrentAccount("00002", BigDecimal.valueOf(1.2), "Customer2");

        accountManage.OpenAccount("00001");
        Assert.assertEquals("00001", accountManage.getSelectedAccountId());
        Assert.assertEquals(BigDecimal.valueOf(1.1), accountManage.getSelectedAccountBalance());
        Assert.assertEquals("Customer1", accountManage.getSelectedAccountCustomerName());
        accountManage.CloseAccount();

        accountManage.OpenAccount("00002");
        Assert.assertEquals("00002", accountManage.getSelectedAccountId());
        Assert.assertEquals(BigDecimal.valueOf(1.2), accountManage.getSelectedAccountBalance());
        Assert.assertEquals("Customer2", accountManage.getSelectedAccountCustomerName());
        accountManage.CloseAccount();
    }

    @Test
    public void testDepositWithdrawn() {
        AccountManage accountManage = new AccountManage();
        accountManage.AddAccount("00001", BigDecimal.valueOf(1.1), "Customer1");
        accountManage.AddCurrentAccount("00002", BigDecimal.valueOf(1.2), "Customer2");

        accountManage.OpenAccount("00001");
        accountManage.Withdraw("00001", BigDecimal.valueOf(10));
        assertEquals(BigDecimal.valueOf(-8.9),accountManage.getSelectedAccountBalance());
        accountManage.Deposit("00001", BigDecimal.valueOf(5.4));
        assertEquals(BigDecimal.valueOf(-3.5),accountManage.getSelectedAccountBalance());
        int temp = accountManage.Withdraw("00001", BigDecimal.valueOf(10));
        assertEquals(-1,temp);
    }
}