package com.example.BookApplication.repository;

import com.example.BookApplication.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


//it takes in two parameters- book data from book class and id consecutive  number
//and Jpa has the pre-defined function for crud and more operations for database


public interface BookRepository extends JpaRepository<Book, Integer> {
//here findByTitle is a method to find the Title in the Book class in entity,
//here especially it doesn't matter if it is case sensitive or not, first it drops the
    // findBy by default and searches for after that word
   public Book findByTitle(String title);
}
