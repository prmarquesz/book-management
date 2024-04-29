package com.bookmanagement.infra.persistence.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookEntityTest {

    @Test
    void testToString() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1L);
        bookEntity.setTitle("title");
        bookEntity.setAuthor("author");
        bookEntity.setIsbn("9780132350884");
        bookEntity.setQuantity(1);

        Assertions.assertEquals(
                "BookEntity{" +
                        "\"id\": 1," +
                        " \"title\": \"title\"," +
                        " \"author\": \"author\", " +
                        "\"isbn\": \"9780132350884\", " +
                        "\"quantity\": 1" +
                        "}", bookEntity.toString());
    }
}