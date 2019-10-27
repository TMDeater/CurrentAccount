package service;

public interface AccountDepositWithdraw {

    public int Deposit(String id, double amount);

    public int Withdraw(String id, double amount);
}
