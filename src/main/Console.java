import service.AccountManage;
import util.Reader;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

import static util.Printer.*;

public class Console {

    public static void main(String[] args) throws IOException {
        AccountManage accountManage;
        Reader reader;
        boolean contin = true;

        // Initialize the account Account List file
        accountManage = new AccountManage();
//        reader = new Reader("./src/main/AccountList.txt");    // for unit test
        reader = new Reader("AccountList.txt");

        String str;
        do{
            str = reader.readAccountLine();
            String[] splitStr = str.split(",");
            switch(splitStr[0]){
                case "Current":
                    accountManage.AddCurrentAccount(splitStr[1],new BigDecimal(splitStr[2]),splitStr[3]);
                    break;
                case "":
                    break;
                default:
                    accountManage.AddAccount(splitStr[1], new BigDecimal(splitStr[2]),splitStr[3]);
                    break;
            }
        } while (!str.equals(""));

        Scanner scanner = new Scanner(System.in);   //initiate scanner for reading user input

        // Loop on handling user interaction
        PrintStartingMessage();
        while(contin){
            PrintOpenAccount();
            String input = scanner.nextLine();
            switch(input){
                case "1":
                    RequestOpenAccount(accountManage, scanner);     // open account
                    ActionAfterOpenAccount(accountManage, scanner); // ask for action
                    break;
                case "2":
                    // exit
                    contin = false;
                    break;
                default:
                    PrintLine("\nInvalid input\n");
                    break;
            }
        }
    }

    private static void RequestOpenAccount(AccountManage accountManage, Scanner scanner) {
        String input;
        int askInput=0;
        do{
            Print("\nPlease input the account ID: ");
            input = scanner.nextLine();
            askInput = accountManage.OpenAccount(input);
        } while(askInput==-1);
    }

    private static void ActionAfterOpenAccount(AccountManage accountManage, Scanner scanner) {
        int askInput=-1;
        String input;
        do {
            // print account information
            PrintAccountInfm(accountManage.getSelectedAccountId(),
                    accountManage.getSelectedAccountBalance(),
                    accountManage.getSelectedAccountCustomerName());
            PrintLine("==========================");
            PrintPerformAction();
            input = scanner.nextLine();
            switch (input){
                case "1":   //Deposit
                    input = AskInputAmount(0, scanner, input);
                    accountManage.Deposit(accountManage.getSelectedAccountId(), new BigDecimal(input));
                    break;
                case "2":   //Withdraw
                    input = AskInputAmount(1, scanner, input);
                    accountManage.Withdraw(accountManage.getSelectedAccountId(), new BigDecimal(input));
                    break;
                case "3":
                    accountManage.CloseAccount();
                    askInput = 0;
                    break;
                default:
                    PrintLine("\nInvalid Input\n");
                    break;
            }
            System.out.println(" ");
        } while(askInput==-1);
    }

    private static String AskInputAmount(int mode, Scanner scanner, String input) {
        String temp=new String();
        if (mode==0)
            temp="deposited";
        else if (mode==1)
            temp="withdrawn";
        while(true){
            Print("Please input the amount to be " + temp + ": ");
            if (scanner.hasNextBigDecimal()){
                input = scanner.nextLine();
                break;
            } else {
                input = scanner.nextLine();
                PrintLine("Invalid Input: " + input);
            }
        }
        return input;
    }
}
