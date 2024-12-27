package view;

import controller.BookController;
import controller.BorrowController;
import entity.Book;
import entity.Borrow;
import repository.BookRepository;
import repository.BorrowRepository;

import java.util.List;
import java.util.Scanner;

import static view.BookView.*;
import static view.BorrowView.*;

public class Main {
    private static BookController bookController = new BookController();
    private static BorrowController borrowController = new BorrowController();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("|        Chương trình quản lý Thư Viện        |");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 1. Quản lý sách                             |");
            System.out.println("| 2. Quản lý phiếu mượn                       |");
            System.out.println("| 3. Thoát                                    |");
            System.out.println("-----------------------------------------------");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    menuBook();
                    break;
                case 2:
                    menuBorrow();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

    public static void menuBook() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("|         Chương trình quản lý sách            |");
            System.out.println("|----------------------------------------------|");
            System.out.println("| 1. Thêm sách                                 |");
            System.out.println("| 2. Sửa thông tin sách                        |");
            System.out.println("| 3. Xóa sách                                  |");
            System.out.println("| 4. Tìm kiếm sách theo tên                    |");
            System.out.println("| 5. Hiển thị danh sách sách                   |");
            System.out.println("| 6. Quay lại                                  |");
            System.out.println("------------------------------------------------");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Book book = inputBook();
                    bookController.add(book);
                    break;
                case 2:
                    if (bookController.getAllBooks().isEmpty()) {
                        System.out.println("Thư viện hiện không có sách nào.");
                    } else {
                        Book bookToUpdate = inputBookToUpdate();
                        BookRepository.update(bookToUpdate);
                    }
                    break;
                case 3:
                    System.out.println("Nhập mã sách cần xóa: ");
                    int bookIdToRemove = Integer.parseInt(sc.nextLine());
                    BookRepository.remove(bookIdToRemove);
                    break;
                case 4:
                    System.out.print("Nhập tên sách cần tìm: ");
                    String title = sc.nextLine();
                    List<Book> foundBooks = bookController.getAllByTitle(title);
                    if (foundBooks.isEmpty()) {
                        System.out.println("Không tìm thấy sách nào với tên: " + title);
                    } else {
                        printSearchBooksByTable(foundBooks);
                    }
                    break;
                case 5:
                    List<Book> books = bookController.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("Thư viện hiện không có sách nào.");
                    } else {
                        System.out.println("Danh sách sách hiện có: ");
                        printBooksTable(books);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

    private static void menuBorrow() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("|        Chương trình quản lý phiếu mượn       |");
            System.out.println("|----------------------------------------------|");
            System.out.println("| 1. Thêm phiếu mượn                           |");
            System.out.println("| 2. Cập nhật trạng thái phiếu mượn            |");
            System.out.println("| 3. Xóa phiếu mượn                            |");
            System.out.println("| 4. Hiển thị danh sách phiếu mượn             |");
            System.out.println("| 5. Quay lại                                  |");
            System.out.println("------------------------------------------------");
            System.out.print("Chọn một tùy chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    List<Book> books = bookController.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("Thư viện hiện không có sách nào.");
                    } else {
                        System.out.println("Danh sách sách hiện có: ");
                        printBooksTable(books);
                        Borrow borrow = inputBorrow();
                        borrowController.add(borrow);
                        System.out.println("Thêm mới thành công!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                case 2:
                    borrowController.updatStatus();
                    System.out.println("Cập nhật thành công");
                    break;
                case 3:
                    System.out.println("Nhập mã phiếu mượn cần xóa: ");
                    int borrowSlipIdToRemove = Integer.parseInt(sc.nextLine());
                    BorrowRepository.remove(borrowSlipIdToRemove);
                    break;
                case 4:
                    List<Borrow> borrows = borrowController.getAllBorrows();
                    if (borrows.isEmpty()) {
                        System.out.println("Không có phiếu mượn nào.");
                    } else {
                        System.out.println("Danh sách phiếu mượn hiện có: ");
                        printBorrowTable(borrows);
                    }
                    break;
                case 5:
                    break;
            }
        }
    }
}