package io.jeremyodell.openaispringdemo.usecase.impl;

import io.jeremyodell.openaispringdemo.usecase.gateway.ChatServiceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TellAJokeImplTest {

    @Mock
    private ChatServiceGateway chatServiceGateway;

    @InjectMocks
    private TellAJokeImpl tellAJoke;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testExecute() {
        // Arrange
        String expectedJoke = "Why don't skeletons fight each other? They don't have the guts.";
        when(chatServiceGateway.execute("Please tell me a classic dad joke!")).thenReturn(expectedJoke);

        // Act
        String result = tellAJoke.execute();

        // Assert
        verify(chatServiceGateway, times(1)).execute("Please tell me a classic dad joke!");
        Assertions.assertEquals(expectedJoke, result, "The returned joke did not match the expected value.");
    }
}
