package com.claudioav.eplataform.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotBlank
        String name,

        @NotBlank
                @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank
        @Size(min = 8, message = "The minimum character size is 8")
        String password
) { }
