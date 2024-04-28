package com.bookmanagement.application.usecase;

import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputData;

public interface BookUseCase {
    BookOutputData addBook(BookInputData bookInputData);

    BookOutputData getBook(Long id);

    void deleteBook(Long id);
}
