package com.example.books.services.impl;

import org.springframework.stereotype.Service;

import com.example.books.domain.Book;
import com.example.books.domain.BookEntity;
import com.example.books.repositories.BookRepository;
import com.example.books.services.BookService;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(final Book book) {
        BookEntity bookEntity = bookToBookEntity(book);
        final BookEntity saveBookEntity =  bookRepository.save(bookEntity);
        return bookEntityToBook(saveBookEntity);
    }

    private BookEntity bookToBookEntity(Book book) {
        return BookEntity.builder().isbn(book.getIsbn()).title(book.getTitle()).author(book.getAuthor()).build();
    }

    private Book bookEntityToBook(BookEntity book) {
        return Book.builder().isbn(book.getIsbn()).title(book.getTitle()).author(book.getAuthor()).build();
    }
}
