package io.jeremyodell.openaispringdemo.configuration;

import io.jeremyodell.openaispringdemo.usecase.TellAJoke;
import io.jeremyodell.openaispringdemo.usecase.gateway.ChatServiceGateway;
import io.jeremyodell.openaispringdemo.usecase.impl.TellAJokeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    TellAJoke tellAJoke(ChatServiceGateway chatServiceGateway) {
        return new TellAJokeImpl(chatServiceGateway);
    }
}
