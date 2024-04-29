package com.bookmanagement.core.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    void shouldThrowExceptionWhenIdIsLessThanOne() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setId(0L));
    }

    @Test
    void shouldSetIdWhenIdIsGreaterThanZero() {
        Book book = new Book();
        book.setId(1L);
        Assertions.assertEquals(1L, book.getId());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        Book book = new Book();
        Assertions.assertThrows(NullPointerException.class, () -> book.setTitle(null));
    }

    @Test
    void shouldThrowExceptionWhenTitleIsEmpty() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setTitle(""));
    }

    @Test
    void shouldThrowExceptionWhenTitleIsBlankWithSpaces() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setTitle("   "));
    }

    @Test
    void shouldThrowExceptionWhenTitleLengthIsGreaterThan200() {
        Book book = new Book();
        String title = "a".repeat(201);
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setTitle(title));
    }

    @Test
    void shouldThrowExceptionWhenAuthorIsNull() {
        Book book = new Book();
        Assertions.assertThrows(NullPointerException.class, () -> book.setAuthor(null));
    }

    @Test
    void shouldThrowExceptionWhenAuthorIsEmptyOrBlankWithSpaces() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setAuthor(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setAuthor("   "));
    }

    @Test
    void shouldThrowExceptionWhenAuthorLengthIsLessThanThree() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setAuthor("aa"));
    }

    @Test
    void shouldThrowExceptionWhenAuthorLengthIsGreaterThanHundred() {
        Book book = new Book();
        String author = "a".repeat(101);
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setAuthor(author));
    }

    @Test
    void shouldThrowExceptionWhenIsbnIsNull() {
        Book book = new Book();
        Assertions.assertThrows(NullPointerException.class, () -> book.setIsbn(null));
    }

    @Test
    void shouldThrowExceptionWhenIsbnIsEmptyOrBlankWithSpaces() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setIsbn(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setIsbn("   "));
    }

    @Test
    void shouldThrowExceptionWhenIsbnLengthIsLessThanThirteen() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setIsbn("123456789012"));
    }

    @Test
    void shouldThrowExceptionWhenIsbnLengthIsGreaterThanFourteen() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setIsbn("123456789012345"));
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsNull() {
        Book book = new Book();
        Assertions.assertThrows(NullPointerException.class, () -> book.setQuantity(null));
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsNegative() {
        Book book = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () -> book.setQuantity(-1));
    }

    @Test
    void shouldCreateBookWithValidData() {
        Book book = new Book("Clean Code", "Robert C. Martin", "9780132350884", 1);

        Assertions.assertEquals("Clean Code", book.getTitle());
        Assertions.assertEquals("Robert C. Martin", book.getAuthor());
        Assertions.assertEquals("9780132350884", book.getIsbn());
        Assertions.assertEquals(1, book.getQuantity());
    }

    @Test
    void shouldCreateBookWithBlankAttributes() {
        Book book = new Book();

        Assertions.assertNull(book.getTitle());
        Assertions.assertNull(book.getAuthor());
        Assertions.assertNull(book.getIsbn());
        Assertions.assertNull(book.getQuantity());
    }

    @Test
    void shouldReturnToString() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setIsbn("9780132350884");
        book.setQuantity(1);

        Assertions.assertEquals(
                "Book{" +
                        "\"id\": 1" +
                        ", \"title\": \"Clean Code\"" +
                        ", \"author\": \"Robert C. Martin\"" +
                        ", \"isbn\": \"9780132350884\"" +
                        ", \"quantity\": 1" +
                        "}", book.toString());
    }
}