package com.example.books.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.domain.Book;
import com.example.books.services.BookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class BookControllers {
    private final BookService bookService;

    public BookControllers(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books/{isbn}")
    public ResponseEntity<Book> createBook(@PathVariable final String isbn, @RequestBody final Book book) {
        book.setIsbn(isbn);
        final Book saveBook = bookService.create(book);
        final ResponseEntity<Book> response = new ResponseEntity<Book>(saveBook, HttpStatus.CREATED);
        return response;
    }
}
