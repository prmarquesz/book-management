package com.bookmanagement.application.mapper;

import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.core.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookMapperTest {
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Test
    void shouldReturnBookMapperInstance() {
        // Act
        BookMapper bookMapperInstance = BookMapper.INSTANCE;

        // Assert
        Assertions.assertNotNull(bookMapperInstance);
    }

    @Test
    void shouldReturnNullWhenBookInputDataIsNull() {
        // Act
        var book = bookMapper.mapToEntity(null);

        // Assert
        Assertions.assertNull(book);
    }

    @Test
    void shouldReturnNullWhenBookEntityIsNull() {
        // Act
        var bookOutputData = bookMapper.mapToOutputData(null);

        // Assert
        Assertions.assertNull(bookOutputData);
    }

    @Test
    void shouldMapCorrectlyToEntity() {
        // Arrange
        BookInputData bookInputData = Mockito.mock(BookInputData.class);
        Mockito.when(bookInputData.getTitle()).thenReturn("Clean Code" );
        Mockito.when(bookInputData.getAuthor()).thenReturn("Robert C. Martin");
        Mockito.when(bookInputData.getInternationalStandardBookNumber()).thenReturn("9780132350884");
        Mockito.when(bookInputData.getQuantity()).thenReturn(1);

        // Act
        var book = bookMapper.mapToEntity(bookInputData);

        // Assert
        Assertions.assertNotNull(book);
        Assertions.assertEquals(bookInputData.getTitle(), book.getTitle(), "Titles do not match");
        Assertions.assertEquals(bookInputData.getAuthor(), book.getAuthor(), "Authors do not match");
        Assertions.assertEquals(bookInputData.getInternationalStandardBookNumber(), book.getIsbn(), "ISBNs do not match");
        Assertions.assertEquals(bookInputData.getQuantity(), book.getQuantity(), "Quantities do not match");
    }

    @Test
    void shouldMapCorrectlyToOutputData() {
        // Arrange
        var book = new Book();
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setIsbn("9780132350884");
        book.setQuantity(1);

        // Act
        var bookOutputData = bookMapper.mapToOutputData(book);

        // Assert
        Assertions.assertNotNull(bookOutputData);
        Assertions.assertEquals(book.getTitle(), bookOutputData.getTitle(), "Titles do not match");
        Assertions.assertEquals(book.getAuthor(), bookOutputData.getAuthor(), "Authors do not match");
        Assertions.assertEquals(book.getIsbn(), bookOutputData.getInternationalStandardBookNumber(), "ISBNs do not match");
        Assertions.assertEquals(book.getQuantity(), bookOutputData.getQuantity(), "Quantities do not match");
    }
}