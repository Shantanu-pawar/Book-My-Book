package shantanu.io.BookMyBook.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shantanu.io.BookMyBook.Controllers.CardController;
import shantanu.io.BookMyBook.Repositories.LibraryCardRepository;
import shantanu.io.BookMyBook.Repositories.StudentRepository;
import shantanu.io.BookMyBook.RequestDTO.AddCardRequest;
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

    public String associateToStudent(AddCardRequest card)throws Exception{
        //Note: we've done the bi-Directional one to one mapping for student and libraryCard so that we can easily access data
        // here we're finding which student got associate to the card

        if(!studentRepository.existsById(card.getStudentRollNo()))throw new Exception("Student Id is Invalid");
        if(!libraryCardRepository.existsById(card.getCardNo())) throw new Exception("Card No is Invalid");

    /* Note to remember for this API
    if we want to complete this API, we've update those FK variables [so for that we've to get student Entity]
    this concept explains here very well : https://vimeo.com/853810094/a61902b349 @2:5:00 Time */

        Optional<Student> optional = studentRepository.findById(card.getStudentRollNo());
        Student studentObj = optional.get();

        Optional<LibraryCard> optionalLibraryCard = libraryCardRepository.findById(card.getCardNo());
        LibraryCard libraryCard = optionalLibraryCard.get();

        //Set the studentObj object in card object
        libraryCard.setStudent(studentObj);
        libraryCard.setCardStatus(card.getCardStatus());
        libraryCard.setNoOfBooksIssued(card.getNoOfBooksIssued());

        //Since its a bidirectional mapping
        //In the studentObj object also we need to set the libraryCard Object
        studentObj.setLibraryCard(libraryCard);

        //any object that has been updated should be saved ???---> Correct Y/N
        //Save both of them : since both were updated
        studentRepository.save(studentObj);

        //CardRepository saving can be skipped bcz
        //studentObj will automatically trigger for the cardRepository Save function
        return "Student and card saved successfully";
    }
}
