package com.personal.rebooked.chat.dto;

import jakarta.validation.constraints.NotNull;

public record CreateChatDTO (
        @NotNull  String sellerId,
        @NotNull  String buyerId,
        @NotNull  String bookId
){
}
