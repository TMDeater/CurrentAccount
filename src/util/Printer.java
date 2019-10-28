package util;

import model.Account;

public class Printer {

    public static void Print(String str){
        System.out.println(str);
    }

    public static void PrintAccountInfm(Account ac){
        Print("Account ID: "+ac.getId());
        Print("Customer Name: "+ac.getCustomerName());
        Print("Account Balance: "+Double.toString(ac.getBalance()));
    }

    public static void PrintOpenAccount(){
        Print("1. Open Account");
        Print("2. Exit");
    }

    public static void PrintPerformAction(){
        Print("1. Deposit");
        Print("2. Withdraw");
        Print("3. Close Account");
    }

    public static void PrintDepositWithdraw(int a, double amount, double amtAfterDeposit){
        String action = new String();
        if (a == 0){
            action = "deposited";
        } else if (a == 1){
            action = "withdrawn";
        }
        Print("$"+amount + " had been "+action+" to your account,");
        Print("Current balance: $"+ amtAfterDeposit);
    }

}
