package com.bookmanagement.application.storage;

import com.bookmanagement.core.entity.Book;

import java.util.List;

public interface BookStorage {
    Book save(Book book);

    void deleteById(Long id);

    Book findById(Long id);

    List<Book> findAll();
}
