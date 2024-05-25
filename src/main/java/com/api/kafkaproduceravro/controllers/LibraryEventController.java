package com.api.kafkaproduceravro.controllers;

import com.api.kafkaproduceravro.models.Library;
import com.api.kafkaproduceravro.services.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/lib")
public class LibraryEventController {
    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody final Library libraryEvent) throws ExecutionException, InterruptedException, TimeoutException {
        libraryService.send(libraryEvent);
        return ResponseEntity.ok().build();
    }
}
