package com.example.books;

import com.example.books.domain.Book;
import com.example.books.domain.BookEntity;

public class TestData {
    private TestData(){

    }
    public static Book testBook(){
        return Book.builder()
                .isbn("12345677")
                .author("ACDDKJ")
                .title("ACVV")
                .build();
    }

    public static BookEntity testBookEntity(){
        return BookEntity.builder()
                .isbn("12345677")
                .author("ACDDKJ")
                .title("ACVV")
                .build();
    }
}
