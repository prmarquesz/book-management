package com.bookmanagement.infra.http.controllers;

import com.bookmanagement.application.storage.BookStorage;
import com.bookmanagement.application.usecase.BookUseCase;
import com.bookmanagement.application.usecase.BookUseCaseImpl;
import com.bookmanagement.application.usecase.iodata.BookOutputData;
import com.bookmanagement.infra.http.controllers.forms.BookForm;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/books")
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookUseCase bookUseCase;

    @Autowired
    public BookController(BookStorage bookStorage) {
        this.bookUseCase = new BookUseCaseImpl(bookStorage);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Object> addBook(
            @RequestBody
            @Valid
            BookForm form, UriComponentsBuilder uriBuilder) {
        LOGGER.info("[BookController] [addBook] Received book ->  {} request", form);
        try {
            BookOutputData bookOutputData = bookUseCase.addBook(form);
            URI uri = uriBuilder.path("/books/{id}").buildAndExpand(bookOutputData.getId()).toUri();
            LOGGER.info("[BookController] [addBook] Book {} added successfully", bookOutputData);
            return ResponseEntity.created(uri).body(bookOutputData);
        } catch (Exception e) {
            LOGGER.error("[BookController] [addBook] Error adding book -> {}", form, e);
            HttpStatus status = e instanceof IllegalArgumentException || e instanceof NullPointerException ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity.status(status).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
