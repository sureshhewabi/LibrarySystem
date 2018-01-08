package lk.colombo.library.webapp.repository;

import lk.colombo.library.webapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
//    Student findByName(String name);
}
