package com.example.BookApplication.dto;

public record BookResponse(
        Long id,
        String title,
        String author,
        String genre
) {
}