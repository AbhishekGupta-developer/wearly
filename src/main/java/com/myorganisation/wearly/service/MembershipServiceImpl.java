package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.request.MembershipRequestDTO;
import com.myorganisation.wearly.dto.response.GenericResponseDTO;
import com.myorganisation.wearly.dto.response.MembershipResponseDTO;
import com.myorganisation.wearly.model.Membership;
import com.myorganisation.wearly.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public MembershipResponseDTO addMembership(MembershipRequestDTO membershipRequestDTO) {
        Membership membership = mapMembershipRequestDTOToMembership(membershipRequestDTO, new Membership());

        membershipRepository.save(membership);

        return mapMembershipToMembershipResponseDTO(membership);
    }

    @Override
    public MembershipResponseDTO getMembership(Long id) {
        Membership membership = membershipRepository.findById(id).orElse(null);
        return mapMembershipToMembershipResponseDTO(membership);
    }

    @Override
    public Page<MembershipResponseDTO> getMembershipPage(Integer page, Integer size, String sortBy, String sortIn) {
        return null;
    }

    @Override
    public MembershipResponseDTO updateMembership(Long id, MembershipRequestDTO membershipRequestDTO) {
        return null;
    }

    @Override
    public GenericResponseDTO removeMembership(Long id) {
        return null;
    }

    //Helper methods

    private Membership mapMembershipRequestDTOToMembership(MembershipRequestDTO membershipRequestDTO, Membership membership) {
        membership.setName(membershipRequestDTO.getName());
        membership.setPrice(membershipRequestDTO.getPrice());
        membership.setDuration(membershipRequestDTO.getDuration());
        membership.setBenefits(membershipRequestDTO.getBenefits());

        return membership;
    }

    private MembershipResponseDTO mapMembershipToMembershipResponseDTO(Membership membership) {
        MembershipResponseDTO membershipResponseDTO = new MembershipResponseDTO();
        membershipResponseDTO.setId(membership.getId());
        membershipResponseDTO.setName(membership.getName());
        membershipResponseDTO.setPrice(membership.getPrice());
        membershipResponseDTO.setDuration(membership.getDuration());
        membershipResponseDTO.setBenefits(membership.getBenefits());

        return membershipResponseDTO;
    }
}
