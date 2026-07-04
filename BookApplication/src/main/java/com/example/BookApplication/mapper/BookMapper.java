package com.example.BookApplication.mapper;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.dto.BookResponse;

public class BookMapper {
    public static Book toEntity(BookResponse dtoResponse){
        if(dtoResponse == null){
            return null;
        }
        Book book = new Book();
        book.setAuthor(dtoResponse.author());
        book.setGenre(dtoResponse.genre());
        book.setTitle(dtoResponse.title());
        return book;
    }

    public static BookResponse toResponse(Book book){
        if(book == null){
            return null;
        }
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre()
        );
    }
}
