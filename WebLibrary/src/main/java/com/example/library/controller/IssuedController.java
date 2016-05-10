package com.example.library.controller;

import com.example.library.domian.Issued;
import com.example.library.service.BookService;
import com.example.library.service.CustomerService;
import com.example.library.service.IssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IssuedController {

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


    @RequestMapping(value = "/issued", method = RequestMethod.GET)
    public String issuedList(Model model){
        model.addAttribute("issueds", issuedService.listAllIssuedBook());
        return "issued";
    }

    //выдача книги
    @RequestMapping(value = "issued/{id}",  method = {RequestMethod.GET, RequestMethod.POST})
    public String newIssued(@PathVariable Integer id, Model model){
        model.addAttribute("books", bookService.getBookById(id));
        model.addAttribute("customers", customerService.listAllCustomers());
        model.addAttribute("issued", new Issued());
        return "issuedform";


    }

    //сохранение
    @RequestMapping(value = "issued", method = RequestMethod.POST)
    public String saveIssued(Issued issued){
        issuedService.saveIssued(issued);
        return "redirect:/issued";
    }

    //просмотр книг у четателя
    @RequestMapping(value = "/customer/book/{id}", method = RequestMethod.GET)
    public String customerBooks(@PathVariable Integer id, Model model){
        model.addAttribute("issueds", issuedService.listCustomer(id));
        return "issued";
    }

    //история выдачи книги
    @RequestMapping(value = "/book/issued/{id}", method = RequestMethod.GET)
    public String history(@PathVariable Integer id, Model model){
        model.addAttribute("issueds", issuedService.listBookHistory(id));
        return "issued";
    }

    //Возврат книги
    @RequestMapping(value = "/issued/back/{id}")
    public String bookBack(@PathVariable Integer id, Model model){
        model.addAttribute("issued", issuedService.getIssuedById(id));
        return "issuedback";
    }


}
