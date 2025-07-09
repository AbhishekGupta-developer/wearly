package com.myorganisation.wearly.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class MembershipResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private String duration;
    private List<String> benefits;
}
