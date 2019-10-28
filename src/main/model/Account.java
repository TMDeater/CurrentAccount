package model;

import java.math.BigDecimal;

public class Account {

    private String id;
    private BigDecimal balance;
    private String customerName;

    public Account(String id, BigDecimal balance, String customerName) {
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getBalance() {

        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isNegativeOrZeroBalance(){
        return this.balance.compareTo(BigDecimal.ZERO)==1?false:true ;
    }
}
