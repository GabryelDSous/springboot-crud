package br.com.gabyrel.endpoint;

import br.com.gabyrel.error.CustomErrorType;
import br.com.gabyrel.model.Student;
import br.com.gabyrel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndPoint {
    private StudentRepository studentDAO;
    @Autowired
    public void setStudentDAO(StudentRepository studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(studentDAO.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        if(studentDAO.findById(id).isEmpty())
            return new ResponseEntity<>(new CustomErrorType("Student not found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(studentDAO.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        return new ResponseEntity<>(studentDAO.save(student),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student){
        studentDAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        studentDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
