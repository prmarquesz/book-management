package com.bookmanagement.infra.persistence.entity;

import jakarta.persistence.*;

@Table(name = "books")
@Entity(name = "Book")
public class BookEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "\"id\": " + id +
                ", \"title\": \"" + title + '\"' +
                ", \"author\": \"" + author + '\"' +
                ", \"isbn\": \"" + isbn + '\"' +
                ", \"quantity\": " + quantity +
                '}';
    }
}
