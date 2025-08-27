package com.personal.rebooked.chat;

import com.personal.rebooked.book.BookService;
import com.personal.rebooked.chat.dto.CreateChatDTO;
import com.personal.rebooked.chat.dto.CreateChatMessageDto;
import com.personal.rebooked.chat.models.Chat;
import com.personal.rebooked.chat.models.ChatMessage;
import com.personal.rebooked.chat.repositories.ChatRepository;
import com.personal.rebooked.chat.repositories.ChatMessageRepository;
import com.personal.rebooked.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserService userService;
    private final BookService bookService;
    private final ChatMessageRepository chatMessageRepository;

    public Chat createChat(CreateChatDTO createChatDTO) {
        Chat chat = new Chat();
        return chatRepository.save(chat);
    }

    public Chat findById(String id) {
        return chatRepository.findById(id).orElse(null);
    }


    public ChatMessage createChatMessage(String chatId, CreateChatMessageDto createChatMessageDto) {
        Chat chat = findById(chatId);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage(createChatMessageDto.message());
        chatMessage.setChatType(createChatMessageDto.chatType());
        chatMessage.setSender(createChatMessageDto.sender());
        chatMessage.setAmount(createChatMessageDto.amount());
        chat.getMessage().add(chatMessage);
        chatRepository.save(chat);
        return  chatMessageRepository.save(chatMessage);
    }

    public ChatMessage setChatMessageAsSeen(String messageId) {
        ChatMessage chatMessage = chatMessageRepository.findById(messageId).orElse(null);
        if (chatMessage != null) {
            chatMessage.setSeen(true);
            return chatMessageRepository.save(chatMessage);
        }
        return null;
    }

    public ChatMessage setChatMessageAsDelivered(String messageId) {
        ChatMessage chatMessage = chatMessageRepository.findById(messageId).orElse(null);
        if (chatMessage != null) {
            chatMessage.setDelivered(true);
            return chatMessageRepository.save(chatMessage);
        }
        return null;
    }
}
