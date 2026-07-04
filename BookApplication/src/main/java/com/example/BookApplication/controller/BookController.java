package com.example.BookApplication.controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import com.example.BookApplication.dto.BookRequest;
import com.example.BookApplication.dto.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //ResponseEntity lets us control the http response - not just the body
    //but also status code and header
    //requestbody helps in convert a htttp request(json/xml) into java object
    // since it cannot directly understand the json format
    @PostMapping("/addbook")
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    //PathVariable is used to extract content and values from url path
    @GetMapping("/getbook/{bookname}")
    public ResponseEntity<BookResponse> getByBookName(@PathVariable("bookname") String title){
        return ResponseEntity.ok(bookService.getBookById(title));
    }


    @PutMapping("/updatebook")
    public ResponseEntity<BookResponse> updateBookbyid(Long id,@RequestBody BookRequest book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
