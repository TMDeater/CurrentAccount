package model;

import java.math.BigDecimal;

public class CurrentAccount extends Account {

    public CurrentAccount(String id, BigDecimal balance, String customerName) {
        super(id, balance, customerName);
    }
}
