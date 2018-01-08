package lk.colombo.library.webapp.repository;

import lk.colombo.library.webapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
//    Book findByName(String name);
}
