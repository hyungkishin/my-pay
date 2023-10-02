package com.mypay.banking.application.service;

import com.mypay.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.mypay.banking.adapter.out.external.bank.FirmbankingResult;
import com.mypay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.mypay.banking.adapter.out.persistence.FirmbankingRequestMapper;
import com.mypay.banking.application.port.in.RequestFirmBankingCommand;
import com.mypay.banking.application.port.in.RequestFirmBankingUseCase;
import com.mypay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.mypay.banking.application.port.out.RequestFirmbankingPort;
import com.mypay.banking.domain.FirmBankingRequest;
import com.mypay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmbankingPort internalPort;

    private final RequestExternalFirmbankingPort externalPort;

    private final FirmbankingRequestMapper mapper;

    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {

        // Business Logic
        // a -> b 계좌
        // 1. a, b 계좌

        // 1. 요청에 대해 정보를 먼저 write, "요청" 상태로
        FirmBankingRequestJpaEntity entity = internalPort.createFirmbankingRequest(
                new FirmBankingRequest.FromBankName(command.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(command.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankingRequest.Amount(command.getAmount()),
                new FirmBankingRequest.FirmBankingStatus(0)
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult externalResult = externalPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber()
        ));

        // 3. 결과에 따라서 1번에서 작성했던 FirmbankingRequest 정보를 update 한다.
        UUID uuid = UUID.randomUUID();

        entity.updateFirmbankingStatus(externalResult.getResultCode(), uuid);

        // 4. 결과를 리턴
        return mapper.mapToDomainEntity(entity, uuid);
    }

}
