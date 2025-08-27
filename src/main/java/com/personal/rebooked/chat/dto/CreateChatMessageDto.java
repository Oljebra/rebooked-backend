package com.personal.rebooked.chat.dto;

import com.personal.rebooked.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateChatMessageDto(
        @NotNull Constants.ChatType chatType,
        @NotBlank String message,
        @NotBlank String sender, //userId for seller / email for buyer
        Float amount
) {
    public CreateChatMessageDto(Constants.ChatType chatType, String message, String sender) {
        this(chatType, message, sender, null);
    }
}
