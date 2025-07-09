package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.request.MembershipRequestDTO;
import com.myorganisation.wearly.dto.response.GenericResponseDTO;
import com.myorganisation.wearly.dto.response.MembershipResponseDTO;
import org.springframework.data.domain.Page;

public interface MembershipService {
    MembershipResponseDTO addMembership(MembershipRequestDTO membershipRequestDTO);
    MembershipResponseDTO getMembership(Long id);
    Page<MembershipResponseDTO> getMembershipPage(Integer page, Integer size, String sortBy, String sortIn);
    MembershipResponseDTO updateMembership(Long id, MembershipRequestDTO membershipRequestDTO);
    GenericResponseDTO removeMembership(Long id);
}
