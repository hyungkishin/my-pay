package com.mypay.banking.adapter.out.external.bank;


import com.mypay.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import com.mypay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.mypay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {

    private final SpringDataRegisteredBankAccountRepository repository;

    /**
     * 외부 은행에 http 를 통해서 실제 은행 계좌 정보를 가져 와야 한다.
     * real 은행 계좌 -> BankAccount 로 parsing 해야 하지만, 임의로 항상 true 를 return 하게 구현함.
     */
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {
        // 실제로 외부 은행에 http 통신을 통해서
        // 펌뱅킹 요청을 하고
        // 그 결과를
        // 외부 은행의 실제 결과를 -> FirmbankingResult 로 파싱
        return new FirmbankingResult(0);
    }

}
