package lk.dhamma.library.webapp.service;

import lk.dhamma.library.webapp.dao.BookDao;
import lk.dhamma.library.webapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookDao.findOne(id);
    }

//    @Override
//    public Book findByName(String name) {
//        return bookDao.findByName(name);
//    }

    @Override
    public void saveBook(Book book) {
        bookDao.save(book);
    }

//    @Override
//    public void updateBook(Book book) {
//        saveBook(book);
//    }

    @Override
    public void deleteBookById(String id) {
        bookDao.delete(id);
    }

//    @Override
//    public void deleteAllBooks() {
//        bookDao.deleteAll();
//    }

    @Override
    public boolean isBookExist(Book book) {
        return findById(book.getAccessionNo()) != null;
    }
}