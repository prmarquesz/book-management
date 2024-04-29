package com.bookmanagement.application.usecase;

import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputData;
import com.bookmanagement.application.usecase.iodata.BookOutputDataImpl;

import java.util.List;

public interface BookUseCase {
    BookOutputData addBook(BookInputData bookInputData);

    void deleteBook(Long id);

    BookOutputData getBook(Long id);

    List<BookOutputDataImpl> getBooks();
}
