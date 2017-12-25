package lk.colombo.library.webapp.service;


import lk.colombo.library.webapp.repository.BorrowalRepository;
import lk.colombo.library.webapp.model.Borrowal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("borrowalService")
@Transactional
public class BorrowalServiceImpl implements BorrowalService{

    @Autowired
    private BorrowalRepository borrowalRepository;

    @Override
    public List<Borrowal> getAllBorrowals() {
        return borrowalRepository.findAll();
    }

    @Override
    public Borrowal findById(Long id) {
        return borrowalRepository.findOne(id);
    }

    @Override
    public void saveBorrowal(Borrowal borrowal) {
        borrowalRepository.save(borrowal);
    }

    @Override
    public void updateBorrowal(Borrowal borrowal) {
        saveBorrowal(borrowal);
    }

    @Override
    public boolean isBorrowalExist(Borrowal borrowal) {
        return findById(borrowal.getId()) != null;
    }

}