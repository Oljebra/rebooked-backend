package com.personal.rebooked.chat;

import com.personal.rebooked.chat.dto.CreateChatDTO;

import com.personal.rebooked.chat.models.Chat;
import com.personal.rebooked.utils.ResponseHandler;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
@SecurityRequirement(name = "bearerAuth")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/")
    public ResponseEntity<Object> createChat(@RequestBody @Valid CreateChatDTO createChatDTO) {
        Chat chat = chatService.createChat(createChatDTO);
        return ResponseHandler.generateResponse(chat, "Chat created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getChatById(@PathVariable String id) {
        Chat chat = chatService.findById(id);
        return ResponseHandler.generateResponse(chat, "Chat fetched successfully");
    }
}
