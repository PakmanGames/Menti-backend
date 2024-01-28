package com.openaiSpring.openaiSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChatMessage {
    private String role;

    // Contents of the message
    private String content;
}
