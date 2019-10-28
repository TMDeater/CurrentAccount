package service;

import model.Account;

import java.util.ArrayList;

import static util.Printer.Print;
import static util.Printer.PrintDepositWithdraw;

public class AccountManage implements AccountDepositWithdraw{

    private ArrayList<Account> accountList;


    public AccountManage(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public AccountManage() {
        this.accountList = new ArrayList<>();
    }

    private int GetAccountById(String id){
        for (int i=0; i<accountList.size(); i++) {
            if (accountList.get(i).getId().equals(id)) {
                return i;
            }
        }
        Print("Could not found account by ID: " + id);
        return -1;
    }

    public int AddAccount(String id, double balance, String customerName){
        for (Account ac:accountList){
            if (id.equals(ac.getId())){
                Print("ID: " + id + "already existed");
                return -1;
            }
        }
        Account newAccount = new Account(id, balance, customerName);
        accountList.add(newAccount);
        Print("ID: " + id + "created");
        return 0;
    }

    @Override
    public int Deposit(String id, double amt){
        double balanceBefore = accountList.get(GetAccountById(id)).getBalance();
        double balanceAfter = balanceBefore + amt;
        accountList.get(GetAccountById(id)).setBalance(balanceAfter);
        PrintDepositWithdraw(0, amt, balanceAfter);
        return 0;
    }

    @Override
    public int Withdraw(String id, double amt) {
        double balanceBefore = accountList.get(GetAccountById(id)).getBalance();
        if (accountList.get(GetAccountById(id)).isNegativeOrZeroBalance()){
            Print("The account has zero or negative balance: " + balanceBefore);
            return -1;
        }
        double balanceAfter = balanceBefore - amt;
        accountList.get(GetAccountById(id)).setBalance(balanceAfter);
        PrintDepositWithdraw(1, amt, balanceAfter);
        return 0;
    }
}
