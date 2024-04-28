package com.bookmanagement.infra.persistence.storage;

import com.bookmanagement.application.storage.BookStorage;
import com.bookmanagement.core.entity.Book;
import com.bookmanagement.infra.persistence.entity.BookEntity;
import com.bookmanagement.infra.persistence.mapper.BookEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookStorageImpl implements BookStorage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookStorageImpl.class);
    private final BookRepository bookRepository;
    private static final BookEntityMapper bookEntityMapper = BookEntityMapper.INSTANCE;

    @Autowired
    public BookStorageImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        LOGGER.info("[BookStorageImpl] [save] Saving book -> {}", book);
        BookEntity bookEntity = bookRepository.save(bookEntityMapper.toEntity(book));
        LOGGER.info("[BookStorageImpl] [save] Saved book -> {}", bookEntity);
        return bookEntityMapper.toDomain(bookEntity);
    }
}