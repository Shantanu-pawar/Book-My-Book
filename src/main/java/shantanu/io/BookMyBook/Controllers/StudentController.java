package shantanu.io.BookMyBook.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shantanu.io.BookMyBook.ENUMS.Department;
import shantanu.io.BookMyBook.RequestDTO.AddStudentWithCardRequest;
import shantanu.io.BookMyBook.ServiceLayer.StudentService;
import shantanu.io.BookMyBook.models.Student;


@RestController
@RequestMapping("/student")
@Slf4j // adding logs here

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody AddStudentWithCardRequest student) {
        try {
            String response = studentService.addStudent(student);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Student not added successfully.{}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/findDeptByID")
    public ResponseEntity<String> findDeptById(@RequestParam("id") int Id){
        try{
            Department department = studentService.getDepartmentByID(Id);
            return new ResponseEntity (department, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Department not found invalid request.{}" , e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
