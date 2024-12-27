package repository;

import entity.Book;
import entity.Borrow;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {
    //Doc file
    public static final String BORROW = "D:\\Codegym\\module2\\CaseStudy\\src\\data\\borrow.csv";

    public static List<Borrow> getAllBorrows() {
        File file = new File(BORROW);
        List<Borrow> borrows = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(", ");
                if (temp.length == 7) {
                    borrows.add(new Borrow(
                            Integer.parseInt(temp[0].trim()),
                            Integer.parseInt(temp[1].trim()),
                            temp[2].trim(),
                            temp[3].trim(),
                            LocalDate.parse(temp[4].trim()),
                            LocalDate.parse(temp[5].trim()),
                            temp[6].trim()
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
        return borrows;
    }

    //Ghi file
    private static void writeFile(List<Borrow> borrows, boolean append) {
        File file = new File(BORROW);
        try (FileWriter fileWriter = new FileWriter(file, append); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Borrow borrow : borrows) {
                bufferedWriter.write(borrowToString(borrow));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    private static String borrowToString(Borrow borrow) {
        return borrow.getSlipId() + ", " + borrow.getBookId() + ", " + borrow.getBorrowerName() + ", " + borrow.getPhoneNumber() + ", " + borrow.getBorrowDate() + ", " + borrow.getReturnDate() + ", " + borrow.getStatus();
    }

    //Them
    public static void add(Borrow borrow) {
        List<Borrow> borrows = new ArrayList<>();
        borrows.add(borrow);
        writeFile(borrows, true);
    }

    public static void updateStatus() {
        LocalDate today = LocalDate.now();
        List<Borrow> borrows = new ArrayList<>();
        for (Borrow borrow : getAllBorrows()) {
            if (borrow.getReturnDate().isBefore(today)) {
                borrow.setStatus("Quá hạn");
            }
            borrows.add(borrow);
        }
        writeFile(borrows, false);
    }

    public static void remove(int id) {
        List<Borrow> borrows = getAllBorrows();
        boolean isRemoved = false;

        for (Borrow borrow : borrows) {
            if (borrow.getSlipId() == id) {
                borrows.remove(borrow);
                isRemoved = true;
                break;
            }
        }

        if (isRemoved) {
            writeFile(borrows, false);
            System.out.println("Xóa sách thành công!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            System.out.println("Không tìm thấy sách với mã: " + id);
        }
    }
}
