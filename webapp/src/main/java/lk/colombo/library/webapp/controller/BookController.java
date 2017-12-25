package lk.colombo.library.webapp.controller;

import lk.colombo.library.webapp.model.Book;
import lk.colombo.library.webapp.service.BookService;
import lk.colombo.library.webapp.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController implements Serializable {

    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") final String id) {
        Book book = bookService.findById(id);
        if (book == null) {
            logger.error("Book with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Book with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        logger.info("Creating Book : {}", book);
        if (bookService.isBookExist(book)) {
            logger.error("Unable to create. A Book with name {} already exist", book.getTitle());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Book with name " +
                    book.getTitle() + " already exist."), HttpStatus.CONFLICT);
        }
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeBook(@PathVariable(value = "id") final String id) {
        logger.info("Deleting Book with id {}", id);

        Book book = bookService.findById(id);
        if (book == null) {
            logger.error("Unable to delete. Book with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Book with id " + id + " not found."), HttpStatus.NOT_FOUND);
        }
        bookService.deleteBookById(id);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }
}
