package controller;

import entity.Book;
import repository.BookRepository;
import service.BookService;
import service.IBookService;

import java.util.List;

public class BookController {
    private IBookService bookService = new BookService();

    public List<Book> getAllByTitle(String title) {
        return bookService.searchBooksByTitle(title);
    }

    public void add(Book book) {
        bookService.add(book);
    }

    public List<Book> update(Book bookUpdate) {
        return BookRepository.getAllBooks();
    }

    public List<Book> remove() {
        return bookService.books();
    }

    public List<Book> getAllBooks() {
        return BookRepository.getAllBooks();
    }
}
