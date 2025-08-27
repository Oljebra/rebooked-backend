package com.personal.rebooked.chat.models;

import com.personal.rebooked.book.models.Book;
import com.personal.rebooked.user.models.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Chat {
    @Id
    private String id;

   @DBRef
   private User seller;

   @DBRef
   private Book book;

   private String buyerEmail;

   private String buyerName;

   @DBRef
   private List<ChatMessage> message;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
