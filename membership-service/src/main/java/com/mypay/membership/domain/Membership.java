package com.mypay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import javax.validation.Valid;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter
    private final String membershipId;

    @Getter
    private final String name;

    @Getter
    private final String email;

    @Getter
    private final String address;

    @Getter
    private final boolean isValid;

    @Getter
    private final boolean isCorp;

    public static Membership generatorMember(MembershipId membershipId,
                                             MembershipName membershipName,
                                             MembershipEmail membershipEmail,
                                             MembershipAddress membershipAddress,
                                             MembershipIsValid membershipIsValid,
                                             MembershipIsCorp membershipIsCorp
    ) {
        return new Membership(membershipId.membershipId,
                membershipName.nameValue,
                membershipEmail.emailValue,
                membershipAddress.addressValue,
                membershipIsValid.isValidValue,
                membershipIsCorp.isCorpValue
        );
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }

        String membershipId;
    }

    @Valid
    public static class MembershipName {

        public MembershipName(String value) {
            this.nameValue = value;
        }

        String nameValue;
    }

    @Valid
    public static class MembershipEmail {
        public MembershipEmail(String value) {
            this.emailValue = value;
        }

        String emailValue;
    }

    @Valid
    public static class MembershipAddress {

        public MembershipAddress(String value) {
            this.addressValue = value;
        }

        String addressValue;
    }

    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }

        boolean isValidValue;
    }

    @Value
    public static class MembershipIsCorp {

        public MembershipIsCorp(boolean value) {
            this.isCorpValue = value;
        }

        boolean isCorpValue;
    }

}
