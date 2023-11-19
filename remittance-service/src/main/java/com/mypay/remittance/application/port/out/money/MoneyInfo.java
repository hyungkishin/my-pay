package com.mypay.remittance.application.port.out.money;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

//  송금서비스에서 필요한 머니의 정보
@Getter
public class MoneyInfo {

    private String membershipId;

    private int balance;

    @JsonIgnore
    public boolean isRechargeNeeded(int amount) {
        return balance < amount;
    }

}
