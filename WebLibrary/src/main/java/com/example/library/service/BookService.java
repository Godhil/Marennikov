package com.example.library.service;

import com.example.library.domian.Book;

public interface BookService {

    //все книги
    Iterable<Book> listAllBooks();

    //поиск книги по id
    Book getBookById(Integer id);

    //сохранение
    Book saveBook(Book book);


}
