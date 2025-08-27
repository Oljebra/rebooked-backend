package com.personal.rebooked.chat;

import com.personal.rebooked.chat.dto.CreateChatMessageDto;
import com.personal.rebooked.chat.models.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@RequiredArgsConstructor
@Controller
public class ChatGateway {

    private final ChatService chatService;

    @EventListener
    public void handleSubscribeEvent(SessionSubscribeEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String destination = headerAccessor.getDestination(); // e.g. "/topic/chat.room123"

        // Only act on a specific chatId (e.g., "room123")
        if (destination != null && destination.startsWith("/topic.chat.")) {
            String chatId = destination.substring("/topic.chat.".length());
            // Optionally, you can send a welcome message or chat history here
            System.out.println("User subscribed to chat: " + chatId);
        }
    }

    @MessageMapping("/topic.chat.{chatId}")
    @SendTo("/topic.chat.{chatId}")
    public  ChatMessage sendChat (@Payload CreateChatMessageDto message, @DestinationVariable String chatId) {
        return chatService.createChatMessage(chatId, message);
    }

    @MessageMapping("/topic.chat.{chatId}.message.delivered.{messageId}")
    public ChatMessage markAsDelivered (@DestinationVariable String chatId , @DestinationVariable String messageId ) {
        return chatService.setChatMessageAsDelivered(messageId);
    }

    @MessageMapping("/topic.chat.{chatId}.message.seen.{messageId}")
    public ChatMessage markAsSeen (@DestinationVariable String chatId ,@DestinationVariable String messageId ) {
        return chatService.setChatMessageAsSeen(messageId);
    }
}
