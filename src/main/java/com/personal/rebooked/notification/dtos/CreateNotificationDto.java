package com.personal.rebooked.notification.dtos;

import com.personal.rebooked.utils.Constants;
import jakarta.validation.constraints.NotBlank;

public record CreateNotificationDto(
        @NotBlank  String userId,
        @NotBlank  String message,
        String id,
        Constants.NotificationMetaType metaType
) {
    public CreateNotificationDto(String userId, String message) {
        this(userId, message, null, null);
    }

}
