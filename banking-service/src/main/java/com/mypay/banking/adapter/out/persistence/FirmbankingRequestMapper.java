package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.domain.FirmBankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmbankingRequestMapper {

    public FirmBankingRequest mapToDomainEntity(FirmBankingRequestJpaEntity entity, UUID uuid) {
        return FirmBankingRequest.generatorFirmbankingRequest(
                new FirmBankingRequest.FirmBankingRequestId(entity.getRequestFirmbankingId() + ""),
                new FirmBankingRequest.FromBankName(entity.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(entity.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(entity.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(entity.getToBankAccountNumber()),
                new FirmBankingRequest.Amount(entity.getAmount()),
                new FirmBankingRequest.FirmBankingStatus(entity.getFirmBankingStatus()),
                uuid
        );
    }
}
