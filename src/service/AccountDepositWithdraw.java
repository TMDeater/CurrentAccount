package service;

import java.math.BigDecimal;

public interface AccountDepositWithdraw {

    public int Deposit(String id, BigDecimal amount);

    public int Withdraw(String id, BigDecimal amount);
}
