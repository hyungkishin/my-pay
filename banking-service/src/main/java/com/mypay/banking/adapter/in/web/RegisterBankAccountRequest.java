package com.mypay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean isValid;

}
