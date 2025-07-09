package com.myorganisation.wearly.controller;

import com.myorganisation.wearly.dto.request.MembershipRequestDTO;
import com.myorganisation.wearly.dto.response.GenericResponseDTO;
import com.myorganisation.wearly.model.Membership;
import com.myorganisation.wearly.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<GenericResponseDTO> addMembership() {
        MembershipRequestDTO silver = new MembershipRequestDTO();
        silver.setName("Silver");
        silver.setPrice(100D);
        silver.setDuration("1 week");

        List<String> silverBenefits = new ArrayList<>();
        silverBenefits.add("Free shipping on orders above ₹999");
        silverBenefits.add("5% cashback on selected categories");
        silverBenefits.add("Early access to seasonal sales");
        silverBenefits.add("Birthday month discount (5%)");
        silverBenefits.add("Standard customer support");
        silverBenefits.add("Access to member-only deals (limited)");

        silver.setBenefits(silverBenefits);

        MembershipRequestDTO gold = new MembershipRequestDTO();
        gold.setName("Gold");
        gold.setPrice(1000D);
        gold.setDuration("1 month");

        List<String> goldBenefits = new ArrayList<>();
        goldBenefits.add("Free shipping on orders above ₹999");
        goldBenefits.add("10% cashback on selected categories");
        goldBenefits.add("48-hour early access to all sales");
        goldBenefits.add("Birthday gift voucher (₹250 or 10% off)");
        goldBenefits.add("Priority customer support");
        goldBenefits.add("Free returns/exchanges");
        goldBenefits.add("Exclusive Gold-only flash deals");
        goldBenefits.add("Monthly reward points bonus");

        gold.setBenefits(goldBenefits);

        MembershipRequestDTO platinum = new MembershipRequestDTO();
        platinum.setName("Platinum");
        platinum.setPrice(10000D);
        platinum.setDuration("12 month");

        List<String> platinumBenefits = new ArrayList<>();
        platinumBenefits.add("Free express shipping (same/next day where applicable)");
        platinumBenefits.add("15% cashback site-wide");
        platinumBenefits.add("72-hour early access to all new arrivals and sales");
        platinumBenefits.add("Birthday + Anniversary gift voucher (₹500 or 15% off)");
        platinumBenefits.add("Dedicated personal shopping assistant/chat");
        platinumBenefits.add("Exclusive Platinum-only products & previews");
        platinumBenefits.add("Triple reward points");
        platinumBenefits.add("Invite-only events or product drops");
        platinumBenefits.add("Surprise quarterly gift boxes / freebies");

        platinum.setBenefits(platinumBenefits);


        membershipService.addMembership(silver);
        membershipService.addMembership(gold);
        membershipService.addMembership(platinum);

        GenericResponseDTO genericResponseDTO = new GenericResponseDTO();
        genericResponseDTO.setSuccess(true);
        genericResponseDTO.setMessage("All three memberships ('Silver', 'Gold', 'Platinum') are added successfully!");

        return new ResponseEntity<>(genericResponseDTO, HttpStatus.OK);
    }
}
