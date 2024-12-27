package controller;

import entity.Book;
import entity.Borrow;
import repository.BorrowRepository;
import service.BorrowService;
import service.IBorrowService;

import java.util.List;

public class BorrowController {
    private IBorrowService borrowService = new BorrowService();

    public void add(Borrow borrow) {
        borrowService.add(borrow);
    }
    public static List<Borrow> getAllBorrows() {
        return BorrowRepository.getAllBorrows();
    }

    public void updatStatus() {
        borrowService.updateStatus();
    }
    public List<Borrow> remove() {
        return borrowService.borrows();
    }
}
