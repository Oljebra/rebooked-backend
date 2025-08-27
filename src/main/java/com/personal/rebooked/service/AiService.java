package com.personal.rebooked.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

import java.util.List;

@dev.langchain4j.service.spring.AiService
public interface AiService {

//    @SystemMessage("You're a helpful assistant that helps people find books to read.")
//    String chatWithContext(@MemoryId String conversationId, @UserMessage String userMessage);

    //TODO: update prompt
    @SystemMessage("You're a helpful assistant that helps people find books to read.")
    String chat(@UserMessage String userMessage);

    @SystemMessage("""
        You are a book recommendation assistant.
        Given a list of books with their details, select and recommend the TOP 5 most relevant books for the user.
        Respond ONLY with a JSON array of exactly 5 book IDs in order of recommendation priority.
        Do not include anything else in the response.
        """)
    String suggestBooks(@UserMessage String booksJson);
}