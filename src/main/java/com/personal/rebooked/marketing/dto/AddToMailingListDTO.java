package com.personal.rebooked.marketing.dto;

import jakarta.validation.constraints.NotBlank;

public record AddToMailingListDTO(
        @NotBlank String email
) {
}
