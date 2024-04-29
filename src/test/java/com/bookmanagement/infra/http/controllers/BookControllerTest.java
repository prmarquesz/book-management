package com.bookmanagement.infra.http.controllers;

import com.bookmanagement.application.storage.BookStorage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BookControllerTest {
    @Autowired
    private BookController bookController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBadRequestWhenBookFormIsNull() throws Exception {
        // Arrange
        URI uri = new URI("/books");

        // Act
        mockMvc
                .perform(post(uri)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenBookFormIsInvalid() throws Exception {
        // Arrange
        URI uri = new URI("/books");
        String body = "{" +
                "  \"title\": \"\"," +
                "  \"author\": \"\"," +
                "  \"internationalStandardBookNumber\": \"\"," +
                "  \"quantity\": 0" +
                "}";

        // Act
        mockMvc
                .perform(post(uri)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void shouldReturnInternalServerErrorWhenDataBaseIsUnavailable() throws Exception {
        // Arrange
        URI uri = new URI("/books");
        String body = "{" +
                "  \"title\": \"title\"," +
                "  \"author\": \"author\"," +
                "  \"internationalStandardBookNumber\": \"1234567890123\"," +
                "  \"quantity\": 1" +
                "}";

        BookStorage bookStorageMock = Mockito.mock(BookStorage.class);
        Mockito.when(bookStorageMock.save(Mockito.any())).thenThrow(new DataAccessException("Database is unavailable") {
            @Override
            public Throwable getRootCause() {
                return super.getRootCause();
            }
        });

        BookController bookController = new BookController(bookStorageMock);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        // Act
        mockMvc
                .perform(post(uri)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void shouldAddBook() throws Exception {
        // Arrange
        URI uri = new URI("/books");
        String body = "{" +
                "  \"title\": \"title\"," +
                "  \"author\": \"author\"," +
                "  \"internationalStandardBookNumber\": \"1234567890123\"," +
                "  \"quantity\": 1" +
                "}";

        // Act
        mockMvc
                .perform(post(uri)
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}