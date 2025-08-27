package com.personal.rebooked.notification.models;

import com.personal.rebooked.book.models.Book;
import com.personal.rebooked.chat.models.Chat;
import com.personal.rebooked.user.models.User;
import com.personal.rebooked.utils.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
public class Notification {
    @Id
    private String id;

    @DBRef
    private User user;

    private String message;

    private boolean read;

    private MetaData metaData;

    @Data
    @NoArgsConstructor
    public static class MetaData {
        @DBRef
        private Book book;

        @DBRef
        private Chat chat;

        private Constants.NotificationMetaType metaType;
    }

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
