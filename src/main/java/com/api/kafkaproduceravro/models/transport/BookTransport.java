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
public class BookTransport {

    @AvroName("bookId")
    private Integer bookId;

    @AvroName("bookName")
    private String bookName;

    @AvroName("bookAuthor")
    private String bookAuthor;
}