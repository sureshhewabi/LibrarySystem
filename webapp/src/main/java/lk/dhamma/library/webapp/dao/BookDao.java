package lk.dhamma.library.webapp.dao;

import lk.dhamma.library.webapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, String> {
//    Book findByName(String name);
}
