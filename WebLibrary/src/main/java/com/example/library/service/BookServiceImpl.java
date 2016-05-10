package com.example.library.service;

import com.example.library.domian.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> listAllBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Book getBookById(Integer id){
        return bookRepository.findOne(id);
    }

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

}
