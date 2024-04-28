package com.bookmanagement.infra.persistence.entity;

import com.bookmanagement.core.entity.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookEntity extends Book {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\"id\": " + identifier +
                ", \"title\": \"" + getTitle() + '\"' +
                ", \"author\": \"" + getAuthor() + '\"' +
                ", \"isbn\": \"" + getIsbn() + '\"' +
                ", \"quantity\": " + getQuantity() +
                '}';
    }
}
