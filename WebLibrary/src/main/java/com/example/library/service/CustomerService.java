package com.example.library.service;

import com.example.library.domian.Customer;

public interface CustomerService {

    //список всех читателей
    Iterable<Customer> listAllCustomers();

    //поиск читателя по id
    Customer getCustomerById(Integer id);

    //сохранение
    Customer saveCustomer(Customer book);
}
