package com.bookmanagement.application.usecase;

import com.bookmanagement.application.mapper.BookMapper;
import com.bookmanagement.application.storage.BookStorage;
import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputData;
import com.bookmanagement.core.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class BookUseCaseImpl implements BookUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookUseCaseImpl.class);
    private final BookStorage bookStorage;
    private final BookMapper bookMapper;

    public BookUseCaseImpl(BookStorage bookStorage, BookMapper bookMapper) {
        this.bookStorage = bookStorage;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookOutputData addBook(BookInputData bookInputData) {
        LOGGER.info("[BookUseCaseImpl] [addBook] Adding the book -> ({}) to storage", bookInputData);
        Objects.requireNonNull(bookInputData, "[BookUseCaseImpl] [addBook] Book input data cannot be null");
        Book book = bookStorage.save(bookMapper.mapToEntity(bookInputData));
        return bookMapper.mapToOutputData(book);
    }
}
