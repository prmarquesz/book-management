package com.bookmanagement.infra.persistence.mapper;

import com.bookmanagement.core.entity.Book;
import com.bookmanagement.infra.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {
    BookEntityMapper INSTANCE = new BookEntityMapperImpl();

    BookEntity toEntity(Book book);

    Book toDomain(BookEntity bookEntity);
}
