package com.personal.rebooked.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record FacebookLoginDTO(
        @NotBlank String accessToken,
        String role
) {
    FacebookLoginDTO ( String accessToken){
        this(accessToken, "user");
    }
}
