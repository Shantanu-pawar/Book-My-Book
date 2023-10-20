package shantanu.io.BookMyBook.ServiceLayer;

import org.hibernate.query.sqm.tree.expression.SqmToDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import shantanu.io.BookMyBook.ENUMS.Department;
import shantanu.io.BookMyBook.Repositories.StudentRepository;
import shantanu.io.BookMyBook.models.LibraryCard;
import shantanu.io.BookMyBook.models.Student;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student) throws Exception{

    /* validation [we're not allowing id to enter in DB] : here we avoid to get an id from user cause we set it to auto -
    and [this can also resist to getting our data updated using old id ]*/
        if(studentRepository.existsById(student.getRollNo())){
            throw new Exception("Id is already present : invalid ID");
        }
        studentRepository.save(student);
        return "student added successfully";
    }

    // as we're finding the dept in ENUM type so we're writting in return type
    public Department getDepartmentByID(Integer rollNo) throws Exception{
        Optional<Student> optionalStudent = studentRepository.findById(rollNo);

        // now we check if rollNumber is exist or not in our db
        if(!optionalStudent.isPresent()){
            throw  new Exception("your entered roll number is invalid");
        }

        Student student = optionalStudent.get();
        return student.getDepartment();
    }


}
