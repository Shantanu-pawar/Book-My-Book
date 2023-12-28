package shantanu.io.BookMyBook.ServiceLayer;

import org.hibernate.query.sqm.tree.expression.SqmToDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import shantanu.io.BookMyBook.ENUMS.Department;
import shantanu.io.BookMyBook.Repositories.LibraryCardRepository;
import shantanu.io.BookMyBook.Repositories.StudentRepository;
import shantanu.io.BookMyBook.RequestDTO.AddStudentWithCardRequest;
import shantanu.io.BookMyBook.models.LibraryCard;
import shantanu.io.BookMyBook.models.Student;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public String addStudent(AddStudentWithCardRequest request) throws Exception{

    /* validation [we're not allowing id to enter in DB] : here we avoid to get an id from user cause we set it to auto -
    and [this can also resist to getting our data updated using old id ]*/
        if(studentRepository.existsById(request.getRollNo())){
            throw new Exception("Id is already present : invalid ID");
        }

        Student student = new Student();
        student.setRollNo(request.getRollNo());
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setGender(request.getGender());
        student.setDepartment(request.getDepartment());
        student.setEmail(request.getEmail());

        studentRepository.save(student);


        LibraryCard card = new LibraryCard();
        card.setCardNo(request.getCardNo());
        card.setCardStatus(request.getCardStatus());

        libraryCardRepository.save(card);
        return "student added successfully";
    }

//    public String addStudent(AddStudentWithCardRequest request) throws Exception{
//
//    /* validation [we're not allowing id to enter in DB] : here we avoid to get an id from user cause we set it to auto -
//    and [this can also resist to getting our data updated using old id ]*/
//        if(studentRepository.existsById(request.getRollNo())){
//            throw new Exception("Id is already present : invalid ID");
//        }
//        Student Student = new Student(request.getName(), request.getEmail()
//                , request.getAge(), request.getGender(), request.getDepartment());
//
//        studentRepository.save(student);
//
//
//        LibraryCard card = new LibraryCard();
//        card.set
//        return "student added successfully";
//    }


    // as we're finding the dept in ENUM type so we're writing in return type
    public Department getDepartmentByID(Integer rollNo) throws Exception{

        Optional<Student> optionalStudent = studentRepository.findById(rollNo);
        // now we check if rollNumber is exist or not in our db
        if(!optionalStudent.isPresent()){
            throw new Exception("student id is not present so can't able to tell");
        }

        Student student = optionalStudent.get();
        return student.getDepartment();
    }

}
