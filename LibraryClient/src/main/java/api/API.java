package api;

import response.*;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface API {

    //список книг библиотеки
    @GET("/rest/book")
    void getBookList(Callback<List<Book>> responce);

    //список читателей библиотеки
    @GET("/rest/customer")
    void getCustomerList(Callback<List<Customer>> responce);

    //список книг у читателя
    @GET("/rest/customer/book/{id}")
    void getCustomerBookList(@Path("id") int id, Callback<List<CustomerBook>> responce);

    //история выдачи книги
    @GET("/rest/book/issued/{id}")
    void getBookHistoryList(@Path("id") int id, Callback<List<BookHistory>> responce);

}
