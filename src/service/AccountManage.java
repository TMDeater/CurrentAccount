package service;

import model.Account;
import model.CurrentAccount;

import java.math.BigDecimal;
import java.util.ArrayList;

import static util.Printer.PrintLine;
import static util.Printer.PrintDepositWithdraw;

public class AccountManage implements AccountDepositWithdraw{

    private ArrayList<Account> accountList;
    private String selectedAccountId;

    public String getSelectedAccountId() {
        return selectedAccountId;
    }

    public BigDecimal getSelectedAccountBalance(){
        return accountList.get(GetAccountIndexById(selectedAccountId)).getBalance();
    }

    public String getSelectedAccountCustomerName(){
        return accountList.get(GetAccountIndexById(selectedAccountId)).getCustomerName();
    }

    public AccountManage(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public AccountManage() {
        this.accountList = new ArrayList<>();
    }

    private int GetAccountIndexById(String id){
        for (int i=0; i<accountList.size(); i++) {
            if (accountList.get(i).getId().equals(id)) {
                return i;
            }
        }
        PrintLine("Could not found account by ID: " + id);
        return -1;
    }

    public int AddAccount(String id, BigDecimal balance, String customerName){
        for (Account ac:accountList){
            if (id.equals(ac.getId())){
                PrintLine("ID: " + id + "already existed");
                return -1;
            }
        }
        Account newAccount = new Account(id, balance, customerName);
        accountList.add(newAccount);
        PrintLine("ID: " + id + "created");
        return 0;
    }

    public int AddCurrentAccount(String id, BigDecimal balance, String customerName){
        for (Account ac:accountList){
            if (id.equals(ac.getId())){
                PrintLine("ID: " + id + "already existed");
                return -1;
            }
        }
        CurrentAccount newAccount = new CurrentAccount(id, balance, customerName);
        accountList.add(newAccount);
        return 0;
    }

    public int OpenAccount(String id){
        int result = GetAccountIndexById(id);
        if (result == -1){
            selectedAccountId = "";
            return -1;
        } else {
            selectedAccountId = id;
            return 0;
        }
    }

    public int CloseAccount(){
        if (selectedAccountId.equals("")){
            PrintLine("No Account is being opened now");
            return -1;
        }
        selectedAccountId = "";
        return 0;
    }

    @Override
    public int Deposit(String id, BigDecimal amt){
        BigDecimal balanceBefore = accountList.get(GetAccountIndexById(id)).getBalance();
        BigDecimal balanceAfter = balanceBefore.add(amt);
        accountList.get(GetAccountIndexById(id)).setBalance(balanceAfter);
        PrintDepositWithdraw(0, amt, balanceAfter); // 0 in 1st parameter means deposit
        return 0;
    }

    @Override
    public int Withdraw(String id, BigDecimal amt) {
        BigDecimal balanceBefore = accountList.get(GetAccountIndexById(id)).getBalance();
        if (accountList.get(GetAccountIndexById(id)).isNegativeOrZeroBalance()){
            PrintLine("The account has zero or negative balance: " + balanceBefore);
            return -1;
        }
        BigDecimal balanceAfter = balanceBefore.subtract(amt);
        accountList.get(GetAccountIndexById(id)).setBalance(balanceAfter);
        PrintDepositWithdraw(1, amt, balanceAfter); // 1 in 1st parameter means withdraw
        return 0;
    }
}
