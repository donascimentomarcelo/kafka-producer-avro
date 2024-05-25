package com.api.kafkaproduceravro.producer;

import com.api.kafkaproduceravro.models.transport.BookTransport;
import com.api.kafkaproduceravro.models.Library;
import com.api.kafkaproduceravro.models.transport.LibraryEventTransport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class LibraryEventsProducer {

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<Integer, LibraryEventTransport> template;

    public SendResult<Integer, LibraryEventTransport> sendLibraryEventSync(final Library libraryEvent) throws ExecutionException, InterruptedException, TimeoutException {

        BookTransport bookTransport = new BookTransport();
        bookTransport.setBookId(libraryEvent.getBook().getBookId());
        bookTransport.setBookName(libraryEvent.getBook().getBookName());
        bookTransport.setBookAuthor(libraryEvent.getBook().getBookAuthor());

        LibraryEventTransport libraryEventTransport = new LibraryEventTransport();
        libraryEventTransport.setLibraryEventId(libraryEvent.getLibraryEvent());
        libraryEventTransport.setLibraryType(libraryEvent.getLibraryType().toUpperCase());
        libraryEventTransport.setBook(bookTransport);

        log.info("Sending Library Event - ID: {}, Book: {}", libraryEvent.getLibraryEvent(), bookTransport);
        log.info("LibraryEventTransport: {}", libraryEventTransport.toString());

        try {
            SendResult<Integer, LibraryEventTransport> result = template.send(topic, libraryEventTransport).get(3, TimeUnit.SECONDS);
            handleSuccess(libraryEventTransport.getLibraryEventId(), libraryEventTransport, result);
            return result;
        } catch (Exception e) {
            log.error("Error sending LibraryEvent to Kafka", e);
            throw e;
        }
    }
    private void handleSuccess(
            final Integer libraryEventId,
            final LibraryEventTransport libraryEventTransport,
            final SendResult<Integer, LibraryEventTransport> result) {
        log.info("LibraryEvent sent successfully to Kafka. ID: {}", libraryEventId);
    }
}
