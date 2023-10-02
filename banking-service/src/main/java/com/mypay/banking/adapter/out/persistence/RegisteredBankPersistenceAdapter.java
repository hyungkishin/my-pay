package com.mypay.banking.adapter.out.persistence;


import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisteredBankAccount;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository repository;

    @Override
    public RegisterBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId,
                                                         RegisteredBankAccount.BankName bankName,
                                                         RegisteredBankAccount.BankAccountNumber bankAccountNumber,
                                                         RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {

        return repository.save(
                new RegisterBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid()
                ));
    }

}
