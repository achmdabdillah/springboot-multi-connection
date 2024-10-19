package com.template.demo.repository.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.template.demo.model.MongoModel.Book;
import com.template.demo.model.OracleModel.Person;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Person findTop1ById(Integer id);

    Person findTop1ByBookName(String bookName);
}
