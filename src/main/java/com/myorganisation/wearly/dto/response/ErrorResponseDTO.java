package com.myorganisation.wearly.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDTO {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorResponseDTO(
            LocalDateTime timestamp,
            String message,
            String details
    ) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
