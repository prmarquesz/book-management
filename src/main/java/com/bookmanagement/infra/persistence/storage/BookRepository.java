package com.bookmanagement.infra.persistence.storage;

import com.bookmanagement.infra.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
