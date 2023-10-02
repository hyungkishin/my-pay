package com.mypay.banking.application.port.in;

import com.mypay.banking.domain.RegisteredBankAccount;

public interface RegisteredBankAccountUseCase {

    RegisteredBankAccount registerMembership(RegisterBankAccountCommand command);

}
