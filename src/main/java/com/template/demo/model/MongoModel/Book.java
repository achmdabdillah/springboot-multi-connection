package com.template.demo.model.MongoModel;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "Book")
public class Book {
    @Id
    private String id;
    private String bookName;
    private String author;
}
