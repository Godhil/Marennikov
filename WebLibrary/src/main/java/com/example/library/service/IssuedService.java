package com.example.library.service;

import com.example.library.domian.Issued;

public interface IssuedService {

    Iterable<Issued> listAllIssuedBook();

    Issued saveIssued(Issued issued);

    //список  книг
    Iterable<Issued> listCustomer(Integer i);

    //история выдачи книг
    Iterable<Issued> listBookHistory(Integer i);

    //выданная книга по id
    Issued getIssuedById(Integer id);





}
