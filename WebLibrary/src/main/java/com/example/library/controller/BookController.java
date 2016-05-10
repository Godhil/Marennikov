package com.example.library.controller;

import com.example.library.domian.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String bookList(Model model){
        model.addAttribute("books", bookService.listAllBooks());
        return "book";
    }


    //новая книга
    @RequestMapping("/book/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "bookform";
    }

    //сохранение
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/book";
    }

    //редактирование
    @RequestMapping("/book/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "bookform";
    }


}
