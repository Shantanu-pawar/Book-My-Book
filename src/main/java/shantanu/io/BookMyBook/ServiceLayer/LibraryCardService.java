package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.Controllers.CardController;
import shantanu.io.BookMyBook.Repositories.LibraryCardRepository;
import shantanu.io.BookMyBook.Repositories.StudentRepository;
import shantanu.io.BookMyBook.models.LibraryCard;
import shantanu.io.BookMyBook.models.Student;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class LibraryCardService {
    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @Autowired
    private StudentRepository studentRepository;

    public String addCard(LibraryCard libraryCard){
        libraryCardRepository.save(libraryCard);
        return "Library Card Added Successfully to the database";
    }

    public String associateToStudent(int cardId, int rollNo) throws Exception{
//Note: we've done the bi-directional one to one mapping for student and libraryCard so that we can easily access data

        // here we're finding which student got associate to the card
        // student should exists
        if(!studentRepository.existsById(rollNo))
            throw new Exception("Student ID is invalid");

        // card should exists
        if(!libraryCardRepository.existsById(cardId))
            throw new Exception("card Number is invalid");

/* Note to remember for this API
 if we want to complete this API so we've update those FK variables [so for that we've to get student Entity]
 this concept explains here very well : https://vimeo.com/853810094/a61902b349 @2:5:00 Time */

        Optional<Student> optionalStudent = studentRepository.findById(rollNo);
        Student StudentObj = optionalStudent.get();

        Optional<LibraryCard> optionalLibraryCard = libraryCardRepository.findById(cardId);
        LibraryCard libraryCard = optionalLibraryCard.get();


//      so now i've got this data, i need to set those variables for foreign key
        libraryCard.setStudent(StudentObj);

        // since we've mapped our student in bi-directional mapping that's why we're setting this
        StudentObj.setLibraryCard(libraryCard);
        studentRepository.save(StudentObj);

        // card Repo saving can be skipped cause student automatically triggered for the card repo save function.
        // because we mapped it bi-directionally - so just save the parent [child automatically get saved]
        return "Student and card added successfully";
    }
}
