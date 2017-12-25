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
    private StudentRepository studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentDao.findOne(id);
    }

//    @Override
//    public Student findByName(String name) {
//        return studentDao.findByName(name);
//    }

    @Override
    public void saveStudent(Student student) {
        studentDao.save(student);
    }

//    @Override
//    public void updateStudent(Student student) {
//        saveStudent(student);
//    }

    @Override
    public void deleteStudentById(String id) {
        studentDao.delete(id);
    }

//    @Override
//    public void deleteAllStudents() {
//        studentDao.deleteAll();
//    }

    @Override
    public boolean isStudentExist(Student student) {
        return findById(student.getId()) != null;
    }
}
