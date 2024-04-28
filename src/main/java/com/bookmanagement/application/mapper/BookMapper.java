package com.bookmanagement.application.mapper;

import com.bookmanagement.application.usecase.iodata.BookInputData;
import com.bookmanagement.application.usecase.iodata.BookOutputDataImpl;
import com.bookmanagement.core.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = new BookMapperImpl();

    @Mapping(source = "internationalStandardBookNumber", target = "isbn")
    Book mapToEntity(BookInputData bookInputData);

    @Mapping(source = "isbn", target = "internationalStandardBookNumber")
    BookOutputDataImpl mapToOutputData(Book book);
}
