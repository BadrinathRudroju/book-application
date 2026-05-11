package com.example.BookApplication.controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//controller only acts for http request and responses

//RestController marks a class as entry point for http requests,
// it handles in API request and sends back a response(json)
//RestController = controller + responsebody
@RestController
@RequestMapping("/Book/v1")
public class BookController {

    private final BookService bookService;

    //autowire injects bookservice dependency injection into bookcontroller class constructor
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //ResponseEntity lets us control the http response - not just the body
    //but also status code and header
    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedbook = bookService.addBook(book);
        return ResponseEntity.ok(savedbook);
    }

    @GetMapping("/getbook/{bookname}")
    public ResponseEntity<Book> getByBookName(@PathVariable("bookname") String name){
        final Book readbook = bookService.getBook(name);
        return ResponseEntity.ok(readbook);
    }
}
