package com.ashu.demo.repository;

import com.ashu.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
    Iterable<Book> findByisAvilableTrue();
}
