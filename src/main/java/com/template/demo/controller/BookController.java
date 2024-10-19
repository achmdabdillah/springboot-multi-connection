package com.template.demo.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.demo.dto.BookDTO;
import com.template.demo.model.MongoModel.Book;
import com.template.demo.service.MongoService.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() throws Exception {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBooks(@PathVariable String id) throws Exception {
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public String insertBook(@RequestBody BookDTO bookDto) {
        log.info("Book: {}", bookDto);
        bookService.saveBook(bookDto);
        return "Book saved";
    }

    @PostMapping("/book/{id}")
    public String updateBook(@PathVariable String id, @RequestBody BookDTO bookDto)
            throws BadRequestException {
        bookService.updateBook(id, bookDto);
        return "Book updated";
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable String id) throws BadRequestException {
        return bookService.deleteBook(id);
    }
}
