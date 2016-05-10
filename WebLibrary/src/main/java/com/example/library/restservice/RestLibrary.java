package com.example.library.restservice;


import com.example.library.domian.Book;
import com.example.library.domian.Customer;
import com.example.library.service.BookService;
import com.example.library.service.CustomerService;
import com.example.library.service.IssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestLibrary {

    private IssuedService issuedService;
    private BookService bookService;
    private CustomerService customerService;

    @Autowired
    public void setIssuedService(IssuedService issuedService){
        this.issuedService = issuedService;
    }

    @Autowired
    public void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }


    //просмотр списка книг
    @RequestMapping(value = "/rest/book", method = RequestMethod.GET)
    public Iterable<Book> bookList(){
        return bookService.listAllBooks();
    }

    //просмотр списка читателей
    @RequestMapping(value = "/rest/customer", method = RequestMethod.GET)
    public Iterable<Customer> customerList(){
        return customerService.listAllCustomers();
    }

    //просмотр книг у читателя
    @RequestMapping(value = "/rest/customer/book/{id}", method = RequestMethod.GET)
    public Iterable customerBooks(@PathVariable Integer id){
        return issuedService.listCustomer(id);
    }

    //просмотр истории выдачи книги
    @RequestMapping(value = "/rest/book/issued/{id}", method = RequestMethod.GET)
    public Iterable history(@PathVariable Integer id){
        return issuedService.listBookHistory(id);
    }


}
