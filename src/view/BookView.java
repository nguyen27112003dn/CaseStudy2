package view;

import entity.Book;
import repository.BookRepository;

import java.util.List;
import java.util.Scanner;

import static view.Main.sc;

public class BookView {
    public static int checkBookId(List<Book> books) {
        while (true) {
            boolean isEmpty = false;
            System.out.print("Nhập mã sách: ");
            int bookId = Integer.parseInt(sc.nextLine());
            for (Book book : books) {
                if (book.getId() == bookId) {
                    System.out.println("Mã sách đã tồn tại. Vui lòng nhập mã khác.");
                    isEmpty = true;
                    break;
                }
            }
            if (!isEmpty) {
                return bookId;
            }
        }
    }

    public static Book inputBook() {
        Scanner sc = new Scanner(System.in);
        int bookId = checkBookId(BookRepository.getAllBooks());
        System.out.print("Nhập tên sách: ");
        String title = sc.nextLine();
        System.out.print("Nhập tên tác giả: ");
        String author = sc.nextLine();
        System.out.print("Nhập thể loại: ");
        String genre = sc.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int publicationYear = Integer.parseInt(sc.nextLine());
        Book book = new Book(bookId, title, author, genre, publicationYear);
        return book;
    }

    public static int checkBookIdUpdate(List<Book> books) {
        while (true) {
            boolean isEmpty = false;
            int bookId = Integer.parseInt(sc.nextLine());
            for (Book book : books) {
                if (book.getId() != bookId) {
                    System.out.println("Mã sách không tồn tại. Vui lòng nhập mã khác.");
                    isEmpty = true;
                    break;
                }
            }
            if (!isEmpty) {
                return bookId;
            }
        }
    }

    public static Book inputBookToUpdate() {
        System.out.println("Cập nhật thông tin sách:");
        System.out.println("Nhập mã cần cập nhật: ");
        int bookId = checkBookIdUpdate(BookRepository.getAllBooks());
        System.out.println("Nhập tên mới: ");
        String title = sc.nextLine();
        System.out.println("Nhập tác giả mới: ");
        String author = sc.nextLine();
        System.out.println("Nhập thể loại mới: ");
        String genre = sc.nextLine();
        System.out.println("Nhập năm xuất bản mới: ");
        int publicationYear = Integer.parseInt(sc.nextLine());
        return new Book(bookId, title, author, genre, publicationYear);
    }

    public static void printBooksTable(List<Book> books) {
        System.out.println("+------+----------------------+----------------------+----------------------+------------+");
        System.out.printf("| %-4s | %-20s | %-20s | %-20s | %-10s |\n", "ID", "Title", "Author", "Genre", "Year");
        System.out.println("+------+----------------------+----------------------+----------------------+------------+");
        for (Book book : books) {
            System.out.printf("| %-4d | %-20s | %-20s | %-20s | %-10d |\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getPublicationYear());
        }
        System.out.println("+------+----------------------+----------------------+----------------------+------------+");
    }

    public static void printSearchBooksByTable(List<Book> books) {
        System.out.println("+------+----------------------+----------------------+----------------------+------------+");
        System.out.printf("| %-4s | %-20s | %-20s | %-20s | %-10s |\n", "ID", "Title", "Author", "Genre", "Year");
        System.out.println("+------+----------------------+----------------------+----------------------+------------+");
        for (Book book : books) {
            System.out.printf("| %-4d | %-20s | %-20s | %-20s | %-10d |\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getPublicationYear());
        }
        System.out.println("+------+----------------------+----------------------+----------------------+------------+");
    }
}
