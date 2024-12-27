package service;

import entity.Book;
import repository.BookRepository;

import java.util.List;

public class BookService implements IBookService {
    private BookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> books() {
        return bookRepository.getAllBooks();
    }

    @Override
    public void add(Book book) {
        BookRepository.add(book);
    }

    @Override
    public void update(Book book) {
        BookRepository.update(book);
    }

    @Override
    public void remove(int id) {
        BookRepository.remove(id);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return this.bookRepository.findAllByTitle(title);
    }

}
