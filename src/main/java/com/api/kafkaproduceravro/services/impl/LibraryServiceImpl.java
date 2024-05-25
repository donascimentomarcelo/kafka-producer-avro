package com.api.kafkaproduceravro.services.impl;

import com.api.kafkaproduceravro.models.Library;
import com.api.kafkaproduceravro.producer.LibraryEventsProducer;
import com.api.kafkaproduceravro.services.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@AllArgsConstructor
@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryEventsProducer libraryEventsProducer;

    @Override
    public void send(final Library libraryEvent) throws ExecutionException, InterruptedException, TimeoutException {
        libraryEventsProducer.sendLibraryEventSync(libraryEvent);
    }
}
