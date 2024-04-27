package com.bookmanagement.application.mapper;

import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputData;
import com.bookmanagement.core.entity.Book;

public interface BookMapper {
    Book mapToEntity(BookInputData bookInputData);
    BookOutputData mapToOutputData(Book book);
}
