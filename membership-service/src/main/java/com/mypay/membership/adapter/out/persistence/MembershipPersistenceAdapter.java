package com.mypay.membership.adapter.out.persistence;


import com.mypay.common.PersistenceAdapter;
import com.mypay.membership.application.port.out.FindMembershipPort;
import com.mypay.membership.application.port.out.ModifyMembershipPort;
import com.mypay.membership.application.port.out.RegisterMembershipPort;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName,
                                                Membership.MembershipEmail membershipEmail,
                                                Membership.MembershipAddress membershipAddress,
                                                Membership.MembershipIsValid membershipIsValid,
                                                Membership.MembershipIsCorp membershipIsCorp) {

        return membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorpValue()
                ));
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId,
                                                Membership.MembershipName membershipName,
                                                Membership.MembershipEmail membershipEmail,
                                                Membership.MembershipAddress membershipAddress,
                                                Membership.MembershipIsValid membershipIsValid,
                                                Membership.MembershipIsCorp membershipIsCorp) {
        MembershipJpaEntity findById = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));

        findById.updateMembership(
                membershipName.getNameValue(),
                membershipAddress.getAddressValue(),
                membershipEmail.getEmailValue(),
                membershipIsCorp.isCorpValue(),
                membershipIsValid.isValidValue()
        );

        return membershipRepository.save(findById);
    }
}
