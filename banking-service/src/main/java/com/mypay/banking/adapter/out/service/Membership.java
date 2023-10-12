package com.mypay.banking.adapter.out.service;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Membership {

    private String membershipId;

    private String name;

    private String email;

    private String address;

    @JsonProperty("valid")
    private boolean isValid;

    @JsonProperty("corp")
    private boolean isCorp;

}
