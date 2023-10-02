package com.mypay.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    private String bankName; // 은행 명

    private String bankAccountNumber; // 은행 계좌

    private boolean isValid; // 유효 여부

    public boolean isAccountNumberValid() {
        return this.isValid;
    }

}
