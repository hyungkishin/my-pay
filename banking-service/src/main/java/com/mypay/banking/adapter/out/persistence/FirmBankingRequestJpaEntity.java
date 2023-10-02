package com.mypay.banking.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "request_firmbanking")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FirmBankingRequestJpaEntity {

    @Id
    @GeneratedValue
    private Long requestFirmbankingId;

    private String fromBankName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private int amount;

    private int firmBankingStatus; // 0 요청, 1 완료, 2 살퍄

    private UUID uuid;

    public FirmBankingRequestJpaEntity(String fromBankName,
                                       String fromBankAccountNumber,
                                       String toBankName,
                                       String toBankAccountNumber,
                                       int amount,
                                       int firmBankingStatus) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.amount = amount;
        this.firmBankingStatus = firmBankingStatus;
    }

    public void updateFirmbankingStatus(int resultCode, UUID uuid) {
        this.firmBankingStatus = resultCode;
        this.uuid = uuid;
    }

}
