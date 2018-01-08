package lk.colombo.library.webapp.service;

import lk.colombo.library.webapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> getAllBooks();

    Book findById(String id);

//    Book findByName(String name);

    void saveBook(Book book);

//    void updateBook(Book book);

    void deleteBookById(String id);

//    void deleteAllBooks();

    boolean isBookExist(Book book);
}
