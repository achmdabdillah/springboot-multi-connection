package com.template.demo.service.MongoService;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.demo.dto.BookDTO;
import com.template.demo.model.MongoModel.Book;
import com.template.demo.repository.MongoRepository.BookRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void saveBook(BookDTO book) {
        Book newBook = new Book();
        newBook.setBookName(book.getBookName());
        newBook.setAuthor(book.getAuthor());
        bookRepository.save(newBook);
    }

    @Transactional
    public void updateBook(String id, BookDTO bookDto) throws BadRequestException {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid book id"));

        existingBook.setBookName(bookDto.getBookName() == null ? existingBook.getBookName() : bookDto.getBookName());
        existingBook.setAuthor(bookDto.getAuthor() == null ? existingBook.getAuthor() : bookDto.getAuthor());
        bookRepository.save(existingBook);
        return;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) throws BadRequestException {
        return bookRepository.findById(id).orElseThrow(() -> new BadRequestException("Invalid book id"));
    }

    public String deleteBook(String id) throws BadRequestException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid book id"));
        bookRepository.delete(book);
        return "Book deleted";
    }
}
