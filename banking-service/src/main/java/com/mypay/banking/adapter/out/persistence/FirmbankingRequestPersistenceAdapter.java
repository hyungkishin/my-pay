package com.mypay.banking.adapter.out.persistence;

import com.mypay.banking.application.port.out.RequestFirmbankingPort;
import com.mypay.banking.domain.FirmBankingRequest;
import com.mypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;


@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository repository;

    @Override
    public FirmBankingRequestJpaEntity createFirmbankingRequest(
            FirmBankingRequest.FromBankName fromBankName,
            FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmBankingRequest.ToBankName toBankName,
            FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankingRequest.Amount amount,
            FirmBankingRequest.FirmBankingStatus firmBankingStatus) {
        return repository.save(
                new FirmBankingRequestJpaEntity(
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        amount.getAmount(),
                        firmBankingStatus.getFirmBankingStatus()
                )
        );
    }

}
