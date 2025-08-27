package com.personal.rebooked.chat.repositories;

import com.personal.rebooked.chat.models.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}
