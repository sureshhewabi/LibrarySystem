package lk.dhamma.library.webapp.service;

import lk.dhamma.library.webapp.model.Borrowal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowalService {
    
    List<Borrowal> getAllBorrowals();

    Borrowal findById(Long id);

    void saveBorrowal(Borrowal borrowal);

    void updateBorrowal(Borrowal borrowal);

    boolean isBorrowalExist(Borrowal borrowal);
}
