package com.example.library.repository;

import com.example.library.domian.Issued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IssuedRepository extends JpaRepository<Issued, Integer> {

    //Просмотр книг у читателя
    @Query("from Issued where customer.id = :id and (back is null or back = '')")
    Iterable<Issued> findByCustomerId(@Param("id") Integer id);

    //История выдачи книги
    @Query("from Issued where book.id = :id order by back")
    Iterable<Issued> findByBookId(@Param("id") Integer id);


    //все не возвращенные книги
    @Query("from Issued where back is null or back = ''")
    Iterable<Issued> findAllIssuedBook();

}
