package com.bookmanagement.core.entity;

import java.util.Objects;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer quantity;

    public Book() {
    }

    public Book(String title, String author, String isbn, Integer quantity) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setQuantity(quantity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id cannot be less than 1");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Objects.requireNonNull(title, "Title cannot be null");
        if (title.isBlank() || title.length() >= 201) {
            throw new IllegalArgumentException("Title cannot be blank or longer than 200 characters");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        Objects.requireNonNull(author, "Author cannot be null");
        if (author.isBlank() || author.length() <= 2 || author.length() >= 101) {
            throw new IllegalArgumentException("Author cannot be blank, less than 3 characters, or greater than 100 characters");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        Objects.requireNonNull(isbn, "ISBN cannot be null");
        if (isbn.isBlank() || isbn.length() <= 12 || isbn.length() >= 15) {
            throw new IllegalArgumentException("ISBN cannot be blank, less than 13 characters, or greater than 14 characters");
        }
        this.isbn = isbn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        Objects.requireNonNull(quantity, "Quantity cannot be null");
        if (quantity <= -1) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\"id\": " + id +
                ", \"title\": \"" + title + '\"' +
                ", \"author\": \"" + author + '\"' +
                ", \"isbn\": \"" + isbn + '\"' +
                ", \"quantity\": " + quantity +
                '}';
    }
}
