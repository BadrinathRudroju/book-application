package com.example.BookApplication.controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import com.example.BookApplication.dto.BookRequest;
import com.example.BookApplication.dto.BookResponse;
import com.example.BookApplication.exceptions.BookNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String dir
    ){
        Sort sort = dir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size ,sort);
        return bookService.getAllBooks(pageable);
    }

    @PostMapping("/addbook")
    public ResponseEntity<BookResponse> addBook(@Valid  @RequestBody Book book){
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

    @PatchMapping(path = "/{title}", consumes = "application/json-patch+json")
    public ResponseEntity<BookResponse> PatchBook(@PathVariable String title, @RequestBody JsonPatch patch){
            try{
                BookResponse bookResponse = bookService.getBookById(title);
                BookResponse bookResponsePatched = applyPatchToBooks(patch, bookResponse);
                bookService.updateBook(bookResponsePatched);
                return ResponseEntity.ok(bookResponsePatched);
            }catch(JsonPatchException | JsonProcessingException e){
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }catch(BookNotFoundException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
    }

    private BookResponse applyPatchToBooks(JsonPatch patch, BookResponse bookResponse)
       throws JsonPatchException, JsonProcessingException{
        JsonNode patched = patch.apply(objectMapper.convertValue(bookResponse, JsonNode.class));
        return objectMapper.treeToValue(patched, BookResponse.class);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
