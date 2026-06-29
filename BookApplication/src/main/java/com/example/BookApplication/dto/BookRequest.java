package com.example.BookApplication.dto;

public record BookRequest(
        String title,
        String author,
        String genre
) {
}