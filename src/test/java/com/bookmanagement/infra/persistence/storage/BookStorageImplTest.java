package com.bookmanagement.infra.persistence.storage;

import com.bookmanagement.application.storage.BookStorage;
import com.bookmanagement.core.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookStorageImplTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldNotSaveBookWhenBookIsNull() {
        BookStorage bookStorage = new BookStorageImpl(bookRepository);
        Assertions.assertThrows(RuntimeException.class, () -> {
            bookStorage.save(null);
        });
    }

    @Test
    void shouldSaveBook() {
        // Arrange
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setIsbn("01234567890123");
        book.setQuantity(1);

        // Act
        var savedBook = new BookStorageImpl(bookRepository).save(book);

        // Assert
        Assertions.assertNotNull(savedBook);
        Assertions.assertNotNull(savedBook.getId());
        Assertions.assertEquals(book.getTitle(), savedBook.getTitle(), "Titles do not match");
        Assertions.assertEquals(book.getTitle(), savedBook.getTitle(), "Titles do not match");
        Assertions.assertEquals(book.getAuthor(), savedBook.getAuthor(), "Authors do not match");
        Assertions.assertEquals(book.getIsbn(), savedBook.getIsbn(), "ISBNs do not match");
        Assertions.assertEquals(book.getQuantity(), savedBook.getQuantity(), "Quantities do not match");
    }
}