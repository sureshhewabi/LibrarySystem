package lk.colombo.library.webapp.service;

import lk.colombo.library.webapp.repository.BookRepository;
import lk.colombo.library.webapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findOne(id);
    }

//    @Override
//    public Book findByName(String name) {
//        return bookRepository.findByName(name);
//    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

//    @Override
//    public void updateBook(Book book) {
//        saveBook(book);
//    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.delete(id);
    }

//    @Override
//    public void deleteAllBooks() {
//        bookRepository.deleteAll();
//    }

    @Override
    public boolean isBookExist(Book book) {
        return findById(book.getAccessionNo()) != null;
    }
}