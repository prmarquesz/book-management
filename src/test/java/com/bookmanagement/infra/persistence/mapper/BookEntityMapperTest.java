package com.bookmanagement.infra.persistence.mapper;

import com.bookmanagement.core.entity.Book;
import com.bookmanagement.infra.persistence.entity.BookEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookEntityMapperTest {
    private final BookEntityMapper bookEntityMapper = BookEntityMapper.INSTANCE;

    @Test
    void shouldReturnBookEntityMapperInstance() {
        Assertions.assertNotNull(BookEntityMapper.INSTANCE);
    }

    @Test
    void shouldReturnNullWhenBookIsNull() {
        Assertions.assertNull(bookEntityMapper.toEntity(null));
    }

    @Test
    void shouldReturnNullWhenBookEntityIsNull() {
        Assertions.assertNull(bookEntityMapper.toDomain(null));
    }

    @Test
    void shouldMapCorrectlyToEntity() {
        // Arrange
        var book = new Book();
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setIsbn("9780132350884");
        book.setQuantity(1);

        // Act
        var bookEntity = bookEntityMapper.toEntity(book);

        // Assert
        Assertions.assertNotNull(bookEntity);
        Assertions.assertEquals(book.getTitle(), bookEntity.getTitle(), "Titles do not match");
        Assertions.assertEquals(book.getAuthor(), bookEntity.getAuthor(), "Authors do not match");
        Assertions.assertEquals(book.getIsbn(), bookEntity.getIsbn(), "ISBNs do not match");
        Assertions.assertEquals(book.getQuantity(), bookEntity.getQuantity(), "Quantities do not match");
    }

    @Test
    void shouldMapCorrectlyToDomain() {
        // Arrange
        var bookEntity = new BookEntity();
        bookEntity.setIdentifier(1L);
        bookEntity.setTitle("Clean Code");
        bookEntity.setAuthor("Robert C. Martin");
        bookEntity.setIsbn("9780132350884");
        bookEntity.setQuantity(1);

        // Act
        var book = bookEntityMapper.toDomain(bookEntity);

        // Assert
        Assertions.assertNotNull(book);
        Assertions.assertEquals(bookEntity.getIdentifier(), book.getId(), "IDs do not match");
        Assertions.assertEquals(bookEntity.getTitle(), book.getTitle(), "Titles do not match");
        Assertions.assertEquals(bookEntity.getAuthor(), book.getAuthor(), "Authors do not match");
        Assertions.assertEquals(bookEntity.getIsbn(), book.getIsbn(), "ISBNs do not match");
        Assertions.assertEquals(bookEntity.getQuantity(), book.getQuantity(), "Quantities do not match");
    }
}