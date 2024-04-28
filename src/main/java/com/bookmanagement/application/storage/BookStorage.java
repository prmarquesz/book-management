package com.bookmanagement.application.storage;

import com.bookmanagement.core.entity.Book;

public interface BookStorage {
    Book save(Book book);

    Book findById(Long id);

    void deleteById(Long id);
}
