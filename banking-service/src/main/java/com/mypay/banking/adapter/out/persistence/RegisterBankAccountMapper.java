package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisterBankAccountMapper {

    public RegisteredBankAccount mapToDomainEntity(RegisterBankAccountJpaEntity entity) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
                new RegisteredBankAccount.RegisteredBankAccountId(entity.getRegisteredBankAccountId() + ""),
                new RegisteredBankAccount.MembershipId(entity.getMembershipId()),
                new RegisteredBankAccount.BankName(entity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(entity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(entity.isLinkedStatusIsValid())
        );
    }
}
