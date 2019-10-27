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

    public static void PrintPerformAction(){

    }
}
