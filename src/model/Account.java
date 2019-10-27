package model;

public class Account {

    private String id;
    private double balance;
    private String customerName;

    public Account(String id, double balance, String customerName) {
        this.id = id;
        this.balance = balance;
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {

        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isNegativeOrZeroBalance(){
        return this.balance>0?false:true ;
    }
}
