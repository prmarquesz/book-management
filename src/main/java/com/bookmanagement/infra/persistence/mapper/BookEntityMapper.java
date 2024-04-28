package com.bookmanagement.infra.persistence.mapper;

import com.bookmanagement.core.entity.Book;
import com.bookmanagement.infra.persistence.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {
    BookEntityMapper INSTANCE = new BookEntityMapperImpl();

    @Mapping(target = "id", ignore = true)
    BookEntity toEntity(Book book);

    @Mapping(source = "identifier", target = "id")
    Book toDomain(BookEntity bookEntity);
}
