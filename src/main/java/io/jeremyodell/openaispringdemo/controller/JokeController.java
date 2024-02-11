package io.jeremyodell.openaispringdemo.controller;

import io.jeremyodell.openaispringdemo.usecase.TellAJoke;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    private final TellAJoke tellAJoke;


    public JokeController(TellAJoke tellAJoke) {
        this.tellAJoke = tellAJoke;
    }

    @GetMapping("/dad-joke")
    public ResponseEntity<String> getDadJoke() {
        String response = tellAJoke.execute();
        return ResponseEntity.ok(response);
    }
}
