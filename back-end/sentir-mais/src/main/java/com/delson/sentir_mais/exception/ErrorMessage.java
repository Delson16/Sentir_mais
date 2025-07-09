package com.delson.sentir_mais.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ErrorMessage {
    
    private String message;
    private HttpStatus status;
    
}
