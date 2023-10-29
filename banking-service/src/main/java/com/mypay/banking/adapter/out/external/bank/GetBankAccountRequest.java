package com.mypay.banking.adapter.out.external.bank;

import lombok.Getter;

@Getter
public class GetBankAccountRequest {
    private String bankName;
    private String bankAccountNumber;

    public GetBankAccountRequest(String bankName, String bankAccountNumber) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }
}
