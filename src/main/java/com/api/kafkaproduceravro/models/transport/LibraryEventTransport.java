package com.api.kafkaproduceravro.models.transport;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import org.apache.avro.reflect.AvroName;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LibraryEventTransport {

    @AvroName("libraryId")
    private Integer libraryEventId;

    @AvroName("libraryType")
    private String libraryType;

    @AvroName("book")
    private BookTransport book;
}