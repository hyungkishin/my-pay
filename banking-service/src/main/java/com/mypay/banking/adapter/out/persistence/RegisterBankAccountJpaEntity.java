package com.mypay.banking.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registered_bank_account")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountJpaEntity {

    @Id
    @GeneratedValue
    private Long registeredBankAccountId;

    private String membershipId;

    private String bankName; // enum

    private String bankAccountNumber;

    private boolean linkedStatusIsValid;

    public RegisterBankAccountJpaEntity(String membershipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }

}
