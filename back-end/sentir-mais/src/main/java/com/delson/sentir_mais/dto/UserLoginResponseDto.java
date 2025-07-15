package com.delson.sentir_mais.dto;

public record UserLoginResponseDto(
        String name,
        String token,
        String id) {
}

