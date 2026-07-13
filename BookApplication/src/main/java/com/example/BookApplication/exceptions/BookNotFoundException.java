package com.example.BookApplication.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String title) {
        super("Book not Found with title " + title);
    }
}
