package lk.colombo.library.webapp.service;

import lk.colombo.library.webapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    Student findById(String id);

//    Student findByName(String name);

    void saveStudent(Student student);

//    void updateStudent(Student student);

    void deleteStudentById(String id);

//    void deleteAllStudents();

    boolean isStudentExist(Student student);
}
