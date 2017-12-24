package lk.dhamma.library.webapp.service;


import lk.dhamma.library.webapp.dao.BorrowalDao;
import lk.dhamma.library.webapp.model.Borrowal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("borrowalService")
@Transactional
public class BorrowalServiceImpl implements BorrowalService{

    @Autowired
    private BorrowalDao borrowalDao;

    @Override
    public List<Borrowal> getAllBorrowals() {
        return borrowalDao.findAll();
    }

    @Override
    public Borrowal findById(Long id) {
        return borrowalDao.findOne(id);
    }

    @Override
    public void saveBorrowal(Borrowal borrowal) {
        borrowalDao.save(borrowal);
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