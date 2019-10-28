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
        reader = new Reader("./src/AccountList.txt");

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
                    Print("Please input the amount to be deposited: ");
                    input = scanner.nextLine();
                    accountManage.Deposit(accountManage.getSelectedAccountId(), new BigDecimal(input));
                    break;
                case "2":   //Withdraw
                    Print("Please input the amount to be withdrawn: ");
                    input = scanner.nextLine();
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
}
