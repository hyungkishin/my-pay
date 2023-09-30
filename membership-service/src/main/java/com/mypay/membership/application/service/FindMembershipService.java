package com.mypay.membership.application.service;

import com.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mypay.membership.adapter.out.persistence.MembershipMapper;
import com.mypay.membership.application.port.in.FindMembershipCommand;
import com.mypay.membership.application.port.in.FindMembershipUseCase;
import com.mypay.membership.application.port.out.FindMembershipPort;
import com.mypay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findmembershipPort;

    private final MembershipMapper membershipMapper;


    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findmembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(entity);
    }
}
