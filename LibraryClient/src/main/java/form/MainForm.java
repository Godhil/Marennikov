package form;

import api.API;
import response.Book;
import response.BookHistory;
import response.Customer;
import response.CustomerBook;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainForm{
    private JPanel panel1;
    private JButton buttonBookList;
    private JButton buttonCustomerList;
    private JList<String> listBooks;
    private JLabel labelCustomer;
    private JLabel labelBookHistory;
    private JList<String> listCustomer;
    private JList<String> listBookHistory;
    private JList<String> listCustomerBook;

    public MainForm(){

        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://localhost:8080/")
                .build();

        final API service = restAdapter.create(API.class);

        DefaultListModel<String> contentListBook = new DefaultListModel<>();
        DefaultListModel<String> contentBookHistory = new DefaultListModel<>();
        DefaultListModel<String> contentCustomerList = new DefaultListModel<>();
        DefaultListModel<String> contentCustomerBook = new DefaultListModel<>();


        //книги
        buttonBookList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                contentListBook.clear();

                //получение списка книг
                service.getBookList(new Callback<List<Book>>() {
                    public void success(List<Book> books, Response response) {
                        //System.out.println("RESPONSE: " + books.get(1).getTitle());

                        for(int i = 0; i < books.size(); i++){
                            contentListBook.addElement(books.get(i).getAuthor() + " \""
                                    +  books.get(i).getTitle() + "\""
                                    + ". Дата издания: "
                                    + books.get(i).getPublishyear());
                        }

                        listBooks.setModel(contentListBook);

                        //нажатие по элементу списка
                        listBooks.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                                int i = listBooks.getSelectedIndex();


                                // начало --> получение истории выдачи книги
                                service.getBookHistoryList(i + 1, new Callback<List<BookHistory>>() {
                                    @Override
                                    public void success(List<BookHistory> bookHistories, Response response) {

                                        contentBookHistory.clear();
                                        String str = "Книга не возвращалась";

                                        if(bookHistories.isEmpty()){
                                            JOptionPane.showMessageDialog(panel1, "Книга не выдавалась");
                                        } else {
                                            for(int i = 0; i < bookHistories.size(); i++){
                                                contentBookHistory.addElement(bookHistories.get(i).getCustomer().getFio() + " Выдача: "
                                                            + bookHistories.get(i).getOut() + " Возврат: "
                                                            + bookHistories.get(i).getBack());
                                            }
                                            listBookHistory.setModel(contentBookHistory);

                                        }
                                    }

                                    @Override
                                    public void failure(RetrofitError retrofitError) {
                                        System.out.println("Ошибка подключения\n" + retrofitError.getMessage());
                                    }
                                });
                                // <-- конец истории выдачи книг

                            }
                        });
                    }

                    public void failure(RetrofitError retrofitError) {
                        JOptionPane.showMessageDialog(panel1, "Ошибка подключения\n" + retrofitError.getMessage());
                    }
                });

            }
        });

        //читатели
        buttonCustomerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                contentCustomerList.clear();

                //получение списка читателей
                service.getCustomerList(new Callback<List<Customer>>() {
                    @Override
                    public void success(List<Customer> customers, Response response) {


                        for(int i = 0; i < customers.size(); i++){
                            contentCustomerList.addElement(customers.get(i).getFio() + ", Дата рождения: " +  customers.get(i).getBirthdate());
                        }

                        listCustomer.setModel(contentCustomerList);

                        //нажатие по элементу списка
                        listCustomer.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                                int i = listCustomer.getSelectedIndex();

                                //начало--> получение списка выданных книг читателю
                                service.getCustomerBookList(i+1, new Callback<List<CustomerBook>>() {
                                    @Override
                                    public void success(List<CustomerBook> customerBooks, Response response) {

                                        contentCustomerBook.clear();
                                        if(customerBooks.isEmpty()){
                                            JOptionPane.showMessageDialog(panel1, "Выданных книг нет");
                                        } else{
                                            for(int i = 0; i < customerBooks.size(); i++){
                                                contentCustomerBook.addElement("\"" + customerBooks.get(i).getBook().getTitle() + "\""
                                                        + " Дата Выдачи: " +  customerBooks.get(i).getOut());
                                            }

                                            listCustomerBook.setModel(contentCustomerBook);

                                        }
                                    }

                                    @Override
                                    public void failure(RetrofitError retrofitError) {
                                        JOptionPane.showMessageDialog(panel1, "Ошибка подключения\n" + retrofitError.getMessage());
                                    }
                                });
                                // <-- конец получения списка книг читателя

                            }
                        });



                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        JOptionPane.showMessageDialog(panel1, "Ошибка подключения\n" + retrofitError.getMessage());
                    }
                });
            }
        });



    }

    public JPanel getPanel1() {
        return panel1;
    }
}
