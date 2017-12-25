package lk.colombo.library.webapp.repository;

import lk.colombo.library.webapp.model.Borrowal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowalRepository extends JpaRepository<Borrowal, Long> {
}
