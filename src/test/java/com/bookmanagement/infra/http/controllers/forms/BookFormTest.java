package com.bookmanagement.infra.http.controllers.forms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookFormTest {

    @Test
    void testToString() {
        BookForm bookForm = new BookForm();
        bookForm.setTitle("title");
        bookForm.setAuthor("author");
        bookForm.setInternationalStandardBookNumber("isbn");
        bookForm.setQuantity(1);

        Assertions.assertEquals("BookForm{" +
                "\"title\": \"title\"," +
                " \"author\": \"author\", " +
                "\"internationalStandardBookNumber\": \"isbn\", " +
                "\"quantity\": 1" +
                "}", bookForm.toString());
    }
}