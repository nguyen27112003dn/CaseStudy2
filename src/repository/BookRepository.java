package repository;

import entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookRepository {
    //Doc file
    public static final String BOOK = "D:\\Codegym\\module2\\CaseStudy\\src\\data\\book.csv";

    public static List<Book> getAllBooks() {
        File file = new File(BOOK);
        List<Book> books = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                if (temp.length == 5) {
                    books.add(new Book(
                            Integer.parseInt(temp[0].trim()),
                            temp[1].trim(),
                            temp[2].trim(),
                            temp[3].trim(),
                            Integer.parseInt(temp[4].trim())
                    ));
                } else {
                    System.out.println("Dữ liệu dòng không hợp lệ: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi chuyển đổi định dạng số: " + e.getMessage());
        }
        return books;
    }

    //Ghi file
    private static void writeFile(List<Book> books, boolean append) {
        File file = new File(BOOK);
        try (FileWriter fileWriter = new FileWriter(file, append); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Book book : books) {
                bufferedWriter.write(bookToString(book));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    private static String bookToString(Book book) {
        return book.getId() + ", " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getGenre() + ", " + book.getPublicationYear();
    }

    //Tim kiem
    public List<Book> findAllByTitle(String title) {
        List<Book> result = new ArrayList<>();
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    //Them
    public static void add(Book book) {
        List<Book> books = new ArrayList<>();
        books.add(book);
        writeFile(books, true);
        System.out.println("Thêm mới thành công!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    //Xoa
    public static void remove(int id) {
        List<Book> books = getAllBooks();
        boolean isRemoved = false;

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                isRemoved = true;
                break;
            }
        }

        if (isRemoved) {
            writeFile(books, false);
            System.out.println("Xóa sách thành công!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            System.out.println("Không tìm thấy sách với mã: " + id);
        }
    }

    //Cap nhat
    public static void update(Book bookUpdate) {
        List<Book> books = getAllBooks();
        boolean isUpdated = false;
        for (Book book : books) {
            if (book.getId() == bookUpdate.getId()) {
                book.setTitle(bookUpdate.getTitle());
                book.setAuthor(bookUpdate.getAuthor());
                book.setGenre(bookUpdate.getGenre());
                book.setPublicationYear(bookUpdate.getPublicationYear());
                isUpdated = true;
                break;
            }
        }
        if (isUpdated) {
            writeFile(books, false);
            System.out.println("Cập nhật sách thành công!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
