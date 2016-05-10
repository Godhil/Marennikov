package com.example.library.repository;

import com.example.library.domian.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
