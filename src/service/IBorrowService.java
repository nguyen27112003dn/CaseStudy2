package service;

import entity.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> borrows();

    void add(Borrow borrow);
    void updateStatus();
    void remove(int id);
}
