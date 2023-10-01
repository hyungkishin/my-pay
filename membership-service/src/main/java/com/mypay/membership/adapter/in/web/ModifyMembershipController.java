package com.mypay.membership.adapter.in.web;

import com.mypay.membership.application.port.in.ModifyMembershipCommand;
import com.mypay.membership.application.port.in.ModifyMembershipUseCase;
import com.mypay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import com.mypay.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping(path = "/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembershipByMembershipId(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }

}
