
package com.delson.sentir_mais.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDto(
        @NotBlank String name,
        @Email @NotBlank String login,
        @NotBlank String password) {
}