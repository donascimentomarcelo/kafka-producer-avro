package com.api.kafkaproduceravro.models;

import lombok.*;
import org.apache.avro.reflect.AvroName;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Library {

    @AvroName("libraryId")
    private Integer libraryEvent;

    @AvroName("libraryType")
    private String libraryType;

    @AvroName("book")
    private Book book;
}