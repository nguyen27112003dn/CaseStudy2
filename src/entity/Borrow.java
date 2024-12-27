package entity;

import java.time.LocalDate;

public class Borrow {
    private int slipId;
    private int bookId;
    private String borrowerName;
    private String phoneNumber;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status;

    public Borrow(int slipId, int bookId, String borrowerName, String phoneNumber, LocalDate borrowDate, LocalDate returnDate, String status) {
        this.slipId = slipId;
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.phoneNumber = phoneNumber;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Borrow(int i, int bookId, String borrowerName, String phoneNumber, int i1, LocalDate borrowDate, LocalDate returnDate, String status) {
    }

    public int getSlipId() {
        return slipId;
    }

    public void setSlipId(int slipId) {
        this.slipId = slipId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
