package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.BankAccount;
import com.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.mypay.banking.adapter.out.persistence.RegisterBankAccountJpaEntity;
import com.mypay.banking.adapter.out.persistence.RegisterBankAccountMapper;
import com.mypay.banking.application.port.in.RegisterBankAccountCommand;
import com.mypay.banking.application.port.in.RegisteredBankAccountUseCase;
import com.mypay.banking.application.port.out.RegisterBankAccountPort;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.domain.RegisteredBankAccount;
import com.mypay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisteredBankAccountUseCase {

    private final RegisterBankAccountPort port;

    private final RequestBankAccountInfoPort externalPort;

    private final RegisterBankAccountMapper mapper;

    @Override
    public RegisteredBankAccount registerMembership(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야 하는 서비스 (비즈니스 로직)

        // (멤버 서비스도 확인?) 해당 부분은 skip

        // 1. 등록된 계좌인지 확인한다. -> 외부에 은행이 이 계좌 정상인지? 확인
        // 1-1 Biz Logic -> External System
        // 1-2 Port -> Adapter -> External System

        // 실제 외부의 은행계좌 정보를 Get
        BankAccount bankAccountInfo = externalPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));

        // 2. 등록 가능한 계좌라면 등록 -> 성공
        if (bankAccountInfo.isAccountNumberValid()) {
            RegisterBankAccountJpaEntity entity = port.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );
            return mapper.mapToDomainEntity(entity);
        }

        // 2-1. 등록 불가 계좌 라면 -> 예외를 리턴
        throw new IllegalArgumentException("유효 하지 않은 계좌 입니다.");
    }

}