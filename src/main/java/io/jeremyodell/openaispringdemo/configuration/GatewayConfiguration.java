package io.jeremyodell.openaispringdemo.configuration;

import io.jeremyodell.openaispringdemo.gateway.ChatService;
import io.jeremyodell.openaispringdemo.usecase.gateway.ChatServiceGateway;
import org.springframework.ai.chat.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    ChatServiceGateway chatServiceGateway(ChatClient chatClient) {
        return new ChatService(chatClient);
    }
}
