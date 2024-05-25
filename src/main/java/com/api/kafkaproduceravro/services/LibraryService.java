package com.api.kafkaproduceravro.services;

import com.api.kafkaproduceravro.models.Library;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface LibraryService {
    public void send(final Library libraryEvent) throws ExecutionException, InterruptedException, TimeoutException;
}
