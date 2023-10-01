package com.mypay.membership.adapter.out.persistence;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "membership")
public class MembershipJpaEntity {

    @Id
    @GeneratedValue
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;

    public MembershipJpaEntity(String name,
                               String address,
                               String email,
                               boolean isValid,
                               boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }

    public void updateMembership(String nameValue, String addressValue, String emailValue, boolean corpValue, boolean validValue) {
        this.name = nameValue;
        this.address = addressValue;
        this.email = emailValue;
        this.isCorp = corpValue;
        this.isValid = validValue;
    }

}
