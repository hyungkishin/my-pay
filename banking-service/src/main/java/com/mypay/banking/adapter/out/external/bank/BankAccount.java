package com.mypay.banking.adapter.out.external.bank;

import lombok.Getter;

@Getter
public class BankAccount {
    private String bankName;
    private String bankAccountNumber;

    private boolean isValid;

    public BankAccount(String bankName, String bankAccountNumber, boolean isValid) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
    }
}
