package com.bookmanagement.application.usecase;

import com.bookmanagement.application.mapper.BookMapper;
import com.bookmanagement.application.storage.BookStorage;
import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputData;
import com.bookmanagement.core.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import java.util.Objects;
import java.util.Optional;

public class BookUseCaseImpl implements BookUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookUseCaseImpl.class);
    private final BookStorage bookStorage;
    private final BookMapper bookMapper;

    public BookUseCaseImpl(BookStorage bookStorage, BookMapper bookMapper) {
        this.bookStorage = bookStorage;
        this.bookMapper = bookMapper;
    }

    public BookUseCaseImpl(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
        this.bookMapper = BookMapper.INSTANCE;
    }

    @Override
    public BookOutputData addBook(BookInputData bookInputData) throws NullPointerException, IllegalArgumentException, DataAccessException {
        LOGGER.info("[BookUseCaseImpl] [addBook] Adding the book -> {} to storage", bookInputData);
        Objects.requireNonNull(bookInputData, "[BookUseCaseImpl] [addBook] Book input data cannot be null");
        Book book = bookStorage.save(bookMapper.mapToEntity(bookInputData));
        return bookMapper.mapToOutputData(book);
    }

    @Override
    public BookOutputData getBook(Long id) {
        LOGGER.info("[BookUseCaseImpl] [getBook] Retrieving the book with id -> {} from storage", id);
        Book book = bookStorage.findById(id);
        return bookMapper.mapToOutputData(book);
    }

    @Override
    public void deleteBook(Long id) {
        LOGGER.info("[BookUseCaseImpl] [deleteBook] Deleting the book with id -> {} from storage", id);
        Optional<Book> book = Optional.ofNullable(bookStorage.findById(id));
        if (book.isEmpty())
            throw new IllegalArgumentException("[BookUseCaseImpl] [deleteBook] Book with id -> " + id + " not found");
        bookStorage.deleteById(id);
    }
}
