package com.bookmanagement.application.usecase.iodata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookOutputDataImplTest {

    @Test
    void testToString() {
        BookOutputDataImpl bookOutputData = new BookOutputDataImpl();
        bookOutputData.setId(1L);
        bookOutputData.setTitle("title");
        bookOutputData.setAuthor("author");
        bookOutputData.setInternationalStandardBookNumber("isbn");
        bookOutputData.setQuantity(1);

        Assertions.assertEquals(
                "BookOutputData{" +
                        "\"id\": 1," +
                        " \"title\": \"title\"," +
                        " \"author\": \"author\", " +
                        "\"internationalStandardBookNumber\": \"isbn\", " +
                        "\"quantity\": 1" +
                        "}", bookOutputData.toString());
    }
}