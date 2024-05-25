package com.api.kafkaproduceravro.models;

import lombok.*;
import org.apache.avro.reflect.AvroName;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {

    @AvroName("bookId")
    private Integer bookId;

    @AvroName("bookName")
    private String bookName;

    @AvroName("bookAuthor")
    private String bookAuthor;
}