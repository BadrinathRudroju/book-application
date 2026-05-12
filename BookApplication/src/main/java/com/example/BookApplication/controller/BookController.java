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

    //here we need to explicitly mention the the id of the book to change it
    // or else it will just add another book which has new id(do it through postman)
    @PutMapping("/updatebook")
    public ResponseEntity<Book> updateBookbyid(@RequestBody Book book){
        Book updatedbook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedbook);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
