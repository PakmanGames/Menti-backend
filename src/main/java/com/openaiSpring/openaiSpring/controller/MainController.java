package com.openaiSpring.openaiSpring.controller;

import com.openaiSpring.openaiSpring.Model.ChatCompletionRequest;
import com.openaiSpring.openaiSpring.Model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    // Auto wiring RestTemplate for making HTTP requests
    @Autowired
    RestTemplate restTemplate;

    // Handling POST requests to /hitOpenaiApi
    @PostMapping("/hitOpenaiApi")
    public String getOpenaiResponse(@RequestBody String prompt) {
        // Creates ChatCompletionRequest object with the model name and the user prompt
        ChatCompletionRequest chatCompletionRequest =
                new ChatCompletionRequest("gpt-3.5-turbo", prompt);
        // Making a POST request to OpenAI API and storing response in a ChatCompletionResponse object
        ChatCompletionResponse response =
                restTemplate.postForObject("https://api.openai.com/v1/chat/completions", chatCompletionRequest, ChatCompletionResponse.class);

        // Checking if the response is empty or null, if not returns the result as a string
        if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
            String result = response.getChoices().get(0).getMessage().getContent();
            return result;
        }

        // Returns original prompt if there was an error or empty result from the request
        return prompt;
    }
}
