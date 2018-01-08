package lk.colombo.library.webapp.controller;

import io.swagger.annotations.Api;
import lk.colombo.library.webapp.model.Student;
import lk.colombo.library.webapp.service.StudentService;
import lk.colombo.library.webapp.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "student", description = "CRUD operations on Student")
public class StudentController implements Serializable {

    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") String id) {
        Student student = studentService.findById(id);
        if (student == null) {
            logger.error("Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Student with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        logger.info("Creating Student : {}", student);
        if (studentService.isStudentExist(student)) {
            logger.error("Unable to create. A Student with name {} already exist", student.getFullName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Student with name " +
                    student.getFullName() + " already exist."), HttpStatus.CONFLICT);
        }
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable(value = "id") String id) {
        logger.info("Deleting Student with id {}", id);

        Student student = studentService.findById(id);
        if (student == null) {
            logger.error("Unable to delete. Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."), HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }
}
