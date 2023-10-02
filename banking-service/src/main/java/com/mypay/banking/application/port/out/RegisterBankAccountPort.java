package com.mypay.banking.application.port.out;

import com.mypay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.mypay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisterBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId
            , RegisteredBankAccount.BankName bankName
            , RegisteredBankAccount.BankAccountNumber bankAccountNumber
            , RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
