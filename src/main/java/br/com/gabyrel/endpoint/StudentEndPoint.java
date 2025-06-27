package br.com.gabyrel.endpoint;

import br.com.gabyrel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
