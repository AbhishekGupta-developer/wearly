package com.myorganisation.wearly.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MembershipRequestDTO {
    private String name;
    private Double price;
    private String duration;
    private List<String> benefits;
}
