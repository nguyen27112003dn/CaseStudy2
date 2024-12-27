package service;

import entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> books();

    void add(Book book);

    void update(Book book);

    void remove(int id);

    List<Book> searchBooksByTitle(String title);
}
