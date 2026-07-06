package com.example.BookApplication.Service;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.dto.BookRequest;
import com.example.BookApplication.dto.BookResponse;
import com.example.BookApplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//This class consists business logic
//Controller should never talk to repository directly, service layer acts as a median
//between them so that it can be tested and separable
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Page<BookResponse> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return bookRepository.findAll(pageable)
                .map(this::toResponse);
    }

    public BookResponse addBook(Book book) {
        Book save = bookRepository.save(book);
        return toResponse(save);
    }

    public BookResponse getBookById(String title){
        Book book = bookRepository.findByTitle(title);
        assert book != null;
        return toResponse(book);
    }

    public BookResponse updateBook(Long id,BookRequest book){
        Book existing = bookRepository.findById(id);

        existing.setGenre(book.genre());
        existing.setTitle(book.title());
        existing.setAuthor(book.author());

        return toResponse(existing);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public BookResponse toResponse(Book book){
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre()
        );
    }
}
