package com.openaiSpring.openaiSpring.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatCompletionRequest {
    // This represents the OpenAI language model that will be used (gpt-3.5-turbo)
    private String model;
    private List<ChatMessage> messages;

    // Constructor to make ChatCompletionRequest object representing POST request
    public ChatCompletionRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<ChatMessage>();
        this.messages.add(new ChatMessage("user", prompt));
    }
}
