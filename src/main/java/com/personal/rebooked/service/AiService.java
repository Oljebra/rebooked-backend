package com.personal.rebooked.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

@dev.langchain4j.service.spring.AiService
public interface AiService {

//    @SystemMessage("You're a helpful assistant that helps people find books to read.")
//    String chatWithContext(@MemoryId String conversationId, @UserMessage String userMessage);

    //TODO: update prompt
    @SystemMessage("You're a helpful assistant that helps people find books to read.")
    String chat(@UserMessage String userMessage);
}