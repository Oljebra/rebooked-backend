package com.personal.rebooked.chat.models;

import com.personal.rebooked.utils.Constants;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
public class ChatMessage {

    @Id
    private String id;
    private String message;
    private Float amount;

    private String sender;

    private  Constants.ChatType chatType;

    private boolean isDelivered = false;
    private boolean isSeen = false;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
