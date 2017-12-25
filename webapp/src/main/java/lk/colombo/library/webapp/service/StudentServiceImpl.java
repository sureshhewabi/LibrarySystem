package lk.colombo.library.webapp.service;

import lk.colombo.library.webapp.repository.StudentRepository;
import lk.colombo.library.webapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findOne(id);
    }

//    @Override
//    public Student findByName(String name) {
//        return studentRepository.findByName(name);
//    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

//    @Override
//    public void updateStudent(Student student) {
//        saveStudent(student);
//    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.delete(id);
    }

//    @Override
//    public void deleteAllStudents() {
//        studentRepository.deleteAll();
//    }

    @Override
    public boolean isStudentExist(Student student) {
        return findById(student.getId()) != null;
    }
}
