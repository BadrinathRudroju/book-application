package com.example.BookApplication.repository;

import com.example.BookApplication.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
   Book findByTitle(String title);
   Book findById(Long id);
}
