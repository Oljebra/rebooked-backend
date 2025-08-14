package com.personal.rebooked.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryDTO(
                @NotBlank String name,
                String description,
                String imageUrl,
                Boolean isSeeded) {
        public CreateCategoryDTO(String name, String description, String imageUrl) {
                this(name, description, imageUrl, false);
        }
}
