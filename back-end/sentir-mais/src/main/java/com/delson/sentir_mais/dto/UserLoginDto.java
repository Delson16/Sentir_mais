package com.delson.sentir_mais.dto;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(
        @NotBlank String login,
        @NotBlank String password) {
}

