package io.jeremyodell.openaispringdemo.usecase.impl;

import io.jeremyodell.openaispringdemo.usecase.TellAJoke;
import io.jeremyodell.openaispringdemo.usecase.gateway.ChatServiceGateway;

public class TellAJokeImpl implements TellAJoke {
    private final ChatServiceGateway chatServiceGateway;

    public TellAJokeImpl(ChatServiceGateway chatServiceGateway) {
        this.chatServiceGateway = chatServiceGateway;
    }

    @Override
    public String execute() {
        return chatServiceGateway.execute("Please tell me a classic dad joke!");
    }
}
