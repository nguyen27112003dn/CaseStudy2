package view;

import entity.Borrow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BorrowView {
    public static Borrow inputBorrow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã phiếu mượn: ");
        int slipId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập mã sách: ");
        int bookId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên người mượn: ");
        String borrowerName = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate borrowDate = null;
        while (borrowDate == null) {
            System.out.println("Nhập ngày mượn (dd-MM-yyyy): ");
            String borrowDateString = sc.nextLine();
            try {
                borrowDate = LocalDate.parse(borrowDateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày mượn không hợp lệ, vui lòng nhập lại theo định dạng dd-MM-yyyy.");
            }
        }
        LocalDate returnDate = null;
        while (returnDate == null) {
            System.out.println("Nhập ngày trả (dd-MM-yyyy): ");
            String returnDateString = sc.nextLine();
            try {
                returnDate = LocalDate.parse(returnDateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày trả không hợp lệ, vui lòng nhập lại theo định dạng dd-MM-yyyy.");
            }
        }
        System.out.println("Cập nhật trạng thái: ");
        String status = sc.nextLine();
        Borrow borrow = new Borrow(slipId, bookId, borrowerName, phoneNumber, borrowDate, returnDate, status);
        return borrow;
    }

    public static void printBorrowTable(List<Borrow> borrows) {
        System.out.println("+------------+------------+----------------------+----------------------+-------------+-------------+------------+");
        System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-10s | %-10s | %-10s |\n",
                "Slip ID", "Book ID", "Borrower Name", "Phone Number", "Borrow Date", "Return Date", "Status");
        System.out.println("+------------+------------+----------------------+----------------------+-------------+-------------+------------+");
        for (Borrow borrow : borrows) {
            System.out.printf("| %-10s | %-10s | %-20s | %-20s | %-11s | %-11s | %-10s |\n",
                    borrow.getSlipId(),
                    borrow.getBookId(),
                    borrow.getBorrowerName(),
                    borrow.getPhoneNumber(),
                    borrow.getBorrowDate().toString(),
                    borrow.getReturnDate().toString(),
                    borrow.getStatus());
        }
        System.out.println("+------------+------------+----------------------+----------------------+-------------+-------------+------------+");
    }
}
