package com.mypay.banking.adapter.out.external.bank;

import lombok.Getter;

@Getter
public class FirmbankingResult {

    private int resultCode; // 0: 성공, 1: 실패

    public FirmbankingResult(int value) {
        this.resultCode = value;
    }
}
