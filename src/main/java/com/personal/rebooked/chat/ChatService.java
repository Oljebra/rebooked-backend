package com.personal.rebooked.chat;

import com.personal.rebooked.book.BookService;
import com.personal.rebooked.chat.repositories.ChatRepository;
import com.personal.rebooked.chat.repositories.MessageRepository;
import com.personal.rebooked.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserService userService;
    private final BookService bookService;
    private final MessageRepository messageRepository;



}
