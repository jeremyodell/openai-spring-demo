package io.jeremyodell.openaispringdemo.gateway;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChatServiceTest {

    @Mock
    private ChatClient chatClient;

    @Mock
    private ChatResponse chatResponse;

    @Mock
    private Generation generation;

    @InjectMocks
    private ChatService chatService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void executeShouldCallChatClientAndReturnResponse() {
        // Arrange
        String inputMessage = "Please tell me a classic dad joke!";
        generation = new Generation("Dad joke response.");



        when(chatResponse.getResult()).thenReturn(generation);
        when(chatClient.call(any(Prompt.class))).thenReturn(chatResponse);

        // Act
        String actualResponse = chatService.execute(inputMessage);

        // Assert

        assertEquals(generation.getOutput().getContent(), actualResponse, "The actual response should match the expected response.");
    }
}
