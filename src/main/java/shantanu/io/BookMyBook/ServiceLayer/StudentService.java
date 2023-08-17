package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.ENUMS.CardStatus;
import shantanu.io.BookMyBook.Repositories.StudentRepository;
import shantanu.io.BookMyBook.models.Card;
import shantanu.io.BookMyBook.models.Student;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
//        whenever we added student our card get automatically created
        Card card = new Card(); // step1: initialise card obj

        // step2 : set the parameter's who are not set by auto
        card.setCardStatus(CardStatus.ACTIVATE);
        card.setStudent(student); // foreign key attribute added

        // step3: now we've to save the card whenever we added student
        student.setCard(card);
        studentRepository.save(student); // saving student here
        return "student added successfully";
    }
}
