package com.myorganisation.wearly.exception;

import com.myorganisation.wearly.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserDoesNotExist(UserDoesNotExistException e) {
        LocalDateTime timestamp = LocalDateTime.now();
        String message = e.getMessage();
        String details = "User doesn't exist";

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(timestamp, message, details);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
