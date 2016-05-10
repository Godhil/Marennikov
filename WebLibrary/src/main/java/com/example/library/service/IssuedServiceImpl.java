package com.example.library.service;

import com.example.library.domian.Issued;
import com.example.library.repository.IssuedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuedServiceImpl implements IssuedService {

    private IssuedRepository issuedRepository;

    @Autowired
    public void setIssuedRepository(IssuedRepository issuedRepository){
        this.issuedRepository = issuedRepository;
    }

    @Override
    public Iterable<Issued> listAllIssuedBook(){
        return issuedRepository.findAllIssuedBook();
    }

    @Override
    public Issued saveIssued(Issued issued){
        return issuedRepository.save(issued);
    }

    @Override
    public Iterable<Issued> listCustomer(Integer id){
        return issuedRepository.findByCustomerId(id);
    }

    @Override
    public Iterable<Issued> listBookHistory(Integer id){
        return issuedRepository.findByBookId(id);
    }

    @Override
    public Issued getIssuedById(Integer id){
        return issuedRepository.findOne(id);
    }

}
