package com.bookmanagement.application.usecase;

import com.bookmanagement.application.mapper.BookMapper;
import com.bookmanagement.application.storage.BookStorage;
import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputData;
import com.bookmanagement.application.usecase.iodata.BookOutputDataImpl;
import com.bookmanagement.core.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookUseCaseImplTest {
    private final BookStorage bookStorage = Mockito.mock(BookStorage.class);
    private final BookMapper bookMapper = Mockito.mock(BookMapper.class);
    private final BookUseCase bookUseCase = new BookUseCaseImpl(bookStorage, bookMapper);

    @Test
    void shouldThrowExceptionWhenBookInputDataIsNull() {
        // Act and Assert
        Assertions.assertThrows(NullPointerException.class, () -> bookUseCase.addBook(null));
    }

    @Test
    void shouldThrowExceptionWhenBookMapToEntityThrowsException() {
        // Arrange
        BookInputData bookInputData = Mockito.mock(BookInputData.class);

        Mockito.when(bookMapper.mapToEntity(bookInputData)).thenThrow(new RuntimeException());

        // Act and Assert
        Assertions.assertThrows(RuntimeException.class, () -> bookUseCase.addBook(bookInputData));
    }

    @Test
    void shouldThrowExceptionWhenBookStorageSaveThrowsException() {
        // Arrange
        BookInputData bookInputData = Mockito.mock(BookInputData.class);

        Mockito.when(bookMapper.mapToEntity(bookInputData)).thenReturn(new Book());
        Mockito.when(bookStorage.save(Mockito.any(Book.class))).thenThrow(new RuntimeException());

        // Act and Assert
        Assertions.assertThrows(RuntimeException.class, () -> bookUseCase.addBook(bookInputData));
    }

    @Test
    void shouldThrowExceptionWhenBookMapToOutputDataThrowsException() {
        // Arrange
        BookInputData bookInputData = Mockito.mock(BookInputData.class);

        Book book = new Book();

        Mockito.when(bookMapper.mapToEntity(bookInputData)).thenReturn(book);
        Mockito.when(bookStorage.save(Mockito.any(Book.class))).thenReturn(book);
        Mockito.when(bookMapper.mapToOutputData(Mockito.any(Book.class))).thenThrow(new RuntimeException());

        // Act and Assert
        Assertions.assertThrows(RuntimeException.class, () -> bookUseCase.addBook(bookInputData));
    }

    @Test
    void shouldSaveBook() {
        // Arrange
        BookInputData bookInputData = Mockito.mock(BookInputData.class);

        Book book = new Book();

        Mockito.when(bookMapper.mapToEntity(bookInputData)).thenReturn(book);
        Mockito.when(bookStorage.save(Mockito.any(Book.class))).thenReturn(book);
        Mockito.when(bookMapper.mapToOutputData(Mockito.any(Book.class))).thenReturn(new BookOutputDataImpl());

        // Act
        BookOutputData bookOutputData = bookUseCase.addBook(bookInputData);

        // Assert
        Mockito.verify(bookMapper, Mockito.atMostOnce()).mapToEntity(bookInputData);
        Mockito.verify(bookStorage, Mockito.atMostOnce()).save(Mockito.any());
        Mockito.verify(bookMapper, Mockito.atMostOnce()).mapToOutputData(Mockito.any());
        Assertions.assertNotNull(bookOutputData);
    }
}