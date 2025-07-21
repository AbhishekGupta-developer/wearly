package com.myorganisation.wearly.dto.response;

import lombok.Data;

@Data
public class GenericResponseDTO {
    private boolean success;
    private String message;

    public GenericResponseDTO() {

    }

    public GenericResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
