package com.mypay.banking.adapter.in.web;


import com.mypay.banking.application.port.in.RequestFirmBankingCommand;
import com.mypay.banking.application.port.in.RequestFirmBankingUseCase;
import com.mypay.banking.domain.FirmBankingRequest;
import com.mypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FirmBankAccountController {

    private final RequestFirmBankingUseCase useCase;

    @PostMapping("/banking/firmbanking/request")
    FirmBankingRequest registeredBankAccount(@RequestBody FirmBankAccountRequest request) {

        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .toBankName(request.getToBankName())
                .amount(request.getAmount())
                .build();

        return useCase.requestFirmBanking(command);
    }
}
