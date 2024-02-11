package io.jeremyodell.openaispringdemo.gateway;

import io.jeremyodell.openaispringdemo.usecase.gateway.ChatServiceGateway;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;

import java.util.List;

public class ChatService implements ChatServiceGateway {
    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String execute(String message) {

        UserMessage userMessage = new UserMessage(message);
        var prompt = new Prompt(List.of(userMessage));
        var aiResponse = chatClient.call(prompt);
        return aiResponse.getResult().getOutput().getContent();
    }
}
