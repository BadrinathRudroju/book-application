package com.example.BookApplication.controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import com.example.BookApplication.dto.BookRequest;
import com.example.BookApplication.dto.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Book/v1")
public class BookController {

    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public Page<BookResponse> findAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return bookService.getAllBooks(page,size);
    }

    @PostMapping("/addbook")
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }


    @GetMapping("/getbook/{bookname}")
    public ResponseEntity<BookResponse> getByBookName(@PathVariable("bookname") String title){
        return ResponseEntity.ok(bookService.getBookById(title));
    }


    @PutMapping("/updatebook/{id}")
    public ResponseEntity<BookResponse> updateBookbyid(@PathVariable Long id,@RequestBody BookRequest book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
