package service;

import entity.Borrow;
import repository.BorrowRepository;

import java.util.List;

public class BorrowService implements IBorrowService {
    private BorrowRepository borrowRepository = new BorrowRepository();

    @Override
    public List<Borrow> borrows() {
        return borrowRepository.getAllBorrows();
    }

    @Override
    public void add(Borrow borrow) {
        BorrowRepository.add(borrow);
    }

    @Override
    public void updateStatus() {
        borrowRepository.updateStatus();
    }

    public void remove(int SlipID) {
        BorrowRepository.remove(SlipID);
    }
}
