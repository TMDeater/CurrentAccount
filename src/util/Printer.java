package util;

import java.math.BigDecimal;

public class Printer {

    public static void PrintLine(String str){
        System.out.println(str);
    }

    public static void Print(String str) { System.out.print(str); }

    public static void PrintStartingMessage(){
        PrintLine("==========================");
        PrintLine("   Bank Account Console");
        PrintLine("==========================");
    }

    public static void PrintAccountInfm(String Id, BigDecimal balance, String customerName){
        PrintLine("Account ID: "+Id);
        PrintLine("Customer Name: "+customerName);
        PrintLine("Account Balance: "+balance);
    }

    public static void PrintOpenAccount(){
        PrintLine("1. Open Account");
        PrintLine("2. Exit");
        Print("Please input your option: ");
    }

    public static void PrintPerformAction(){
        PrintLine("1. Deposit");
        PrintLine("2. Withdraw");
        PrintLine("3. Close Account");
        Print("Please input your option: ");
    }

    public static void PrintDepositWithdraw(int a, BigDecimal amount, BigDecimal amtAfterDeposit){
        String action = new String();
        if (a == 0){
            action = "deposited";
        } else if (a == 1){
            action = "withdrawn";
        }
        PrintLine("$"+amount + " had been "+action+" to your account,");
        PrintLine("Current balance: $"+ amtAfterDeposit);
    }

}
