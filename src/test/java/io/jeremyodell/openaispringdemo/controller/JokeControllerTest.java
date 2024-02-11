package io.jeremyodell.openaispringdemo.controller;


import io.jeremyodell.openaispringdemo.usecase.TellAJoke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JokeController.class)
class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TellAJoke tellAJoke;

    @BeforeEach
    void setUp() {
        when(tellAJoke.execute()).thenReturn("Why did the coffee file a police report? It got mugged.");
    }

    @Test
    void getDadJokeShouldReturnJoke() throws Exception {
        mockMvc.perform(get("/dad-joke").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Why did the coffee file a police report? It got mugged.")));

        verify(tellAJoke, times(1)).execute();
    }
}
