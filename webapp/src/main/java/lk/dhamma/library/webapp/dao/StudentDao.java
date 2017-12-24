package lk.dhamma.library.webapp.dao;

import lk.dhamma.library.webapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, String> {
//    Student findByName(String name);
}
